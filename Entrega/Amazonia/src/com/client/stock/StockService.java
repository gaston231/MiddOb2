package com.client.stock;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.17
 * 2015-11-15T13:06:23.478-02:00
 * Generated source version: 2.7.17
 * 
 */
@WebServiceClient(name = "StockService", 
                  wsdlLocation = "http://localhost:8090/soap-esb/Stock?wsdl",
                  targetNamespace = "http://stock.com/") 
public class StockService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://stock.com/", "StockService");
    public final static QName StockPort = new QName("http://stock.com/", "StockPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/soap-esb/Stock?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(StockService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/soap-esb/Stock?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public StockService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public StockService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StockService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public StockService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public StockService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public StockService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns Stock
     */
    @WebEndpoint(name = "StockPort")
    public Stock getStockPort() {
        return super.getPort(StockPort, Stock.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Stock
     */
    @WebEndpoint(name = "StockPort")
    public Stock getStockPort(WebServiceFeature... features) {
        return super.getPort(StockPort, Stock.class, features);
    }

}