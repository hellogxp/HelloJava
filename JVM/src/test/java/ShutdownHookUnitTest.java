import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/11/24 22:52
 */
public class ShutdownHookUnitTest {
    @Test
    public void givenAHook_WhenShutsDown_ThenHookShouldBeExecuted() {
        Thread hook = new Thread(() -> System.out.println("In the middle of a shutdown"));
        Runtime.getRuntime().addShutdownHook(hook);
    }

    @Test
    public void addingAHook_WhenThreadAlreadyStarted_ThenThrowsAnException() {
        Thread runningHook = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        runningHook.start();
        assertThatThrownBy(() -> Runtime.getRuntime().addShutdownHook(runningHook)).isInstanceOf(
            IllegalArgumentException.class).hasMessage("Hook already running");
    }

    @Test
    public void addingAHook_WhenAlreadyExists_ThenAnExceptionWouldBeThrown() {
        Thread hook = new Thread(() -> {
        });
        Runtime.getRuntime().addShutdownHook(hook);

        assertThatThrownBy(() -> Runtime.getRuntime().addShutdownHook(hook)).isInstanceOf(
            IllegalArgumentException.class).hasMessage("Hook previously registered");
    }

    @Test
    public void removeAHook_WhenItIsAlreadyRegistered_ThenWouldDeRegisterTheHook() {
        Thread hook = new Thread(() -> System.out.println("Won't run!"));
        Runtime.getRuntime().addShutdownHook(hook);

        assertThat(Runtime.getRuntime().removeShutdownHook(hook)).isTrue();
    }
}