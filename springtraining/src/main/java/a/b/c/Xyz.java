package a.b.c;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Xyz {

    @Autowired
    private MyOtherBean       myOtherBean;

    private final MyOtherBean myOtherBeanRef2;

    private MyOtherBean       myOtherBeanRef3;

    @Autowired
    public Xyz(final MyOtherBean myOtherBeanRef2) {
        this.myOtherBeanRef2 = myOtherBeanRef2;
        System.out.println("Xyz yaratılıyor");
    }

    @Autowired
    public void setMe(final MyOtherBean myOtherBeanRef3) {
        this.myOtherBeanRef3 = myOtherBeanRef3;
    }

    @PostConstruct
    public void initMe() {
        System.out.println("init");
    }

    @PreDestroy
    public void destoryMe() {
        System.out.println("destroy");
    }

    public void exec() {
        System.out.println("Executing ...");
        System.out.println("Ref1 : " + this.myOtherBean);
        System.out.println("Ref2 : " + this.myOtherBeanRef2);
        System.out.println("Ref3 : " + this.myOtherBeanRef3);
    }

}
