package ePuerto;

import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import static java.nio.file.LinkOption.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;


public class WatchDir {

    private final WatchService watcher;
    private final Map<WatchKey,Path> keys;
    private final boolean recursive;
    private boolean trace = false;

    @SuppressWarnings("unchecked")
    static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return (WatchEvent<T>)event;
    }

    /**
     * Register the given directory with the WatchService
     */
    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        if (trace) {
            Path prev = keys.get(key);
            if (prev == null) {
                System.out.format("register: %s\n", dir);
            } else {
                if (!dir.equals(prev)) {
                    System.out.format("update: %s -> %s\n", prev, dir);
                }
            }
        }
        keys.put(key, dir);
    }

    /**
     * Register the given directory, and all its sub-directories, with the
     * WatchService.
     */
    private void registerAll(final Path start) throws IOException {
        // register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException
            {
                register(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Creates a WatchService and registers the given directory
     */
    WatchDir(Path dir, boolean recursive) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.keys = new HashMap<WatchKey,Path>();
        this.recursive = recursive;

        if (recursive) {
            System.out.format("Scanning %s ...\n", dir);
            registerAll(dir);
            System.out.println("Done.");
        } else {
            register(dir);
        }

        // enable trace after initial registration
        this.trace = true;
    }

    /**
     * Process all events for keys queued to the watcher
     * @throws IOException
     * @throws InterruptedException
     */
    void processEvents() throws IOException, InterruptedException {
        for (;;) {

            // wait for key to be signalled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            Path dir = keys.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!!");
                continue;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();

                // TBD - provide example of how OVERFLOW event is handled
                if (kind == OVERFLOW) {
                    continue;
                }

                // Context for directory entry event is the file name of entry
                WatchEvent<Path> ev = cast(event);
                Path name = ev.context();
                Path child = dir.resolve(name);

                // print out event
                System.out.format("%s: %s\n", event.kind().name(), child);

                // if directory is created, and watching recursively, then
                // register it and its sub-directories

                if (kind == ENTRY_CREATE){
                	if (dir.getFileName().toString().equals("recepcion")){
                		//Thread.sleep(5000);
                		System.out.println("\n La orden "+child.getFileName().toString()+" fue agregada...\n");
                		//Files.copy(child, Paths.get(dir.getParent().toString()+"/confirmar/"+child.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                	}
                	else if (dir.getFileName().toString().equals("confirmar")) {
                		File f = new File(Paths.get(dir.getParent().toString()+"/recepcion/"+child.getFileName()).toString());
						if (! f.exists()){
							System.out.println("\n     !!!     La orden que quiere confirmar no existe     !!!     \n");}
						else{
							System.out.println("\n La orden "+child.getFileName().toString()+" esta siendo confirmada...\n");
							Thread.sleep(5000);
// cambiar el copy delete x un move
							Files.copy(child, Paths.get(dir.getParent().toString()+"/procesados/"+child.getFileName()), StandardCopyOption.REPLACE_EXISTING);
							System.out.println("\n La orden "+child.getFileName().toString()+" fue procesada ...\n");
							Files.delete(Paths.get(dir.getParent().toString()+"/recepcion/"+child.getFileName()));
							Files.delete(child);
						}
					}
                	else if (dir.getFileName().toString().equals("anular")) {
                		File f = new File(Paths.get(dir.getParent().toString()+"/recepcion/"+child.getFileName()).toString());
						if (! f.exists()){
							System.out.println("\n     !!!     la orden que quiere anular no existe     !!!     \n");}
						else{
							System.out.println("\n La orden "+child.getFileName().toString()+" esta siendo anulada...\n");
							Thread.sleep(5000);
							Files.copy(child, Paths.get(dir.getParent().toString()+"/procesados/"+child.getFileName()), StandardCopyOption.REPLACE_EXISTING);
							System.out.println("\n La orden "+child.getFileName().toString()+" fue procesada ...\n");
							Files.delete(Paths.get(dir.getParent().toString()+"/recepcion/"+child.getFileName()));
							Files.delete(child);
						}
					}
                }

                if (recursive && (kind == ENTRY_CREATE)) {
                    try {
                        if (Files.isDirectory(child, NOFOLLOW_LINKS)) {
                            registerAll(child);
                            System.out.println(child.toString());
                            //aca hago todo ?? ver como genero confirmacion

                            //recepcion
                            //confirmacion
                            //anulacion
                            //procesados
                        }
                    } catch (IOException x) {
                        // ignore to keep sample readbale
                    }
                }
            }

            // reset key and remove from set if directory no longer accessible
            boolean valid = key.reset();
            if (!valid) {
                keys.remove(key);

                // all directories are inaccessible
                if (keys.isEmpty()) {
                    break;
                }
            }
        }
    }

    static void usage() {
        System.err.println("usage: java WatchDir [-r] dir");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // parse arguments
        if (args.length == 0 || args.length > 2)
            usage();
        boolean recursive = false;
        int dirArg = 0;
        if (args[0].equals("-r")) {
            if (args.length < 2)
                usage();
            recursive = true;
            dirArg++;
        }

        // register directory and process its events
        Path dir = Paths.get(args[dirArg]);
        new WatchDir(dir, recursive).processEvents();
    }
}
