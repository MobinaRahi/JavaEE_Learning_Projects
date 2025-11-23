package ee.session03.factor_program.model.common;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaProvider {
    @Getter
    public final static JpaProvider instance = new JpaProvider();
    private final EntityManagerFactory factory;

    private JpaProvider() {
        try {
            factory = Persistence.createEntityManagerFactory("mftPU");
        } catch (Exception e) {
            throw new RuntimeException("failed to initiate EntityManagerFactory", e);
        }
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void close() {
        factory.close();
    }


}
