package a.b.c;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyOtherBean {


    public MyOtherBean() {
        System.out.println("MyOtherBean yaratılıyor");
    }

    public void exec() {
        System.out.println("Executing ...");
    }

}
