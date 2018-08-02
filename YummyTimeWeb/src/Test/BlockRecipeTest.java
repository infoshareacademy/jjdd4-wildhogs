package dao;

import com.sun.istack.internal.NotNull;
import org.junit.jupiter.api.Test;

import javax.naming.Name;
import javax.validation.constraints.Null;
import javax.websocket.OnError;
import java.io.IOException;

class BlockRecipeTest {

    private Name name;

    @Test
    Name ifNameisName() {
        this.name = name;
        return name;
    }

    @Null
    @Test
    void ifNameisntName() {
        this.name = null;
    }

}

//
//
//
//    public BlockRecipe(String name, String pathToPicture, Long id) {
//        this.name = name;
//        this.pathToPicture = pathToPicture;
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPathToPicture() {
//        return pathToPicture;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
//
//    @org.junit.jupiter.api.Test
//    void getPathToPicture() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void getId() {
//    }
//}

//    @Test
//    void assertTimeout() {
//        // arrange
//        Runnable task = () -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {
//            }
//        };
//
//        // waits for the task to finish before failing the test
//        Assertions.assertTimeout(Duration.ofMillis(100), task::run);
//    }