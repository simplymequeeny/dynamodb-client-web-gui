package simplymequeeny.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simplymequeeny.utils.ConnectionType;

@Service
public class HelperService {

    @Value("${endpoint.url}")
    private String ENDPOINT_URL;

    public ConnectionType getConnectionType() {
        return (ENDPOINT_URL.isEmpty()) ? ConnectionType.AWS : ConnectionType.LOCAL;
    }
}
