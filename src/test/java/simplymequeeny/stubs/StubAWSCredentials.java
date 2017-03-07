package simplymequeeny.stubs;

import com.amazonaws.auth.AWSCredentials;

public class StubAWSCredentials implements AWSCredentials {

    @Override
    public String getAWSAccessKeyId() {
        return "dummyAccessKeyId";
    }

    @Override
    public String getAWSSecretKey() {
        return "awsSecretKey";
    }
}
