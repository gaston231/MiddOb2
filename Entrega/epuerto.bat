cd "C:\Middleware"

if not exist "C:\Middleware\testdir\recepcion" mkdir C:\Middleware\testdir\recepcion
if not exist "C:\Middleware\testdir\confirmar" mkdir C:\Middleware\testdir\confirmar
if not exist "C:\Middleware\testdir\anular" mkdir C:\Middleware\testdir\anular
if not exist "C:\Middleware\testdir\procesados" mkdir C:\Middleware\testdir\procesados
if not exist "ePuerto\WatchDir.class" javac ePuerto\WatchDir.java

@ECHO off 
title MiddleWare folder watcher 
color 9 
echo Escuchando la carpeta recepcion...  
echo.
 
start cmd /k  "cd "C:\Middleware" & title MiddleWare folder watcher & color 9 & echo Escuchando la carpeta confirmar...& echo. & java ePuerto.WatchDir "C:\Middleware\testdir\confirmar" "
start cmd /k  "cd "C:\Middleware" & title MiddleWare folder watcher & color 9 & echo Escuchando la carpeta anular...& echo. & java ePuerto.WatchDir "C:\Middleware\testdir\anular" "

java ePuerto.WatchDir "C:\Middleware\testdir\recepcion"
 