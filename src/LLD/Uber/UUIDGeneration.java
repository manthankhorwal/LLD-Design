package LLD.Uber;

import java.util.UUID;

public class UUIDGeneration implements IdGenerationStrategy{
    @Override
    public String provideID() {
        return UUID.randomUUID().toString();
    }
}
