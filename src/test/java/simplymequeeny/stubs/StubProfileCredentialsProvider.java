package simplymequeeny.stubs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

public class StubProfileCredentialsProvider extends ProfileCredentialsProvider {

    public AWSCredentials getCredentials() {
        return new BasicAWSCredentials("dummy","stub");
    }
}
