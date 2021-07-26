package kluszynski.example.model;


import javax.persistence.Transient;

public class AbstractEntity {
    // only for tracking origin of the data in higher level services
    @Transient
    private String serviceMetadata;

    public String getServiceMetadata() {
        return serviceMetadata;
    }

    public void setServiceMetadata(String serviceMetadata) {
        this.serviceMetadata = serviceMetadata;
    }
}
