package a.b.c;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TestScanBean {

    public TestScanBean() {
        System.out.println("TestScanBean yaratılıyor");
    }

    public void exec() {
        System.out.println("Executing ...");
    }

}
