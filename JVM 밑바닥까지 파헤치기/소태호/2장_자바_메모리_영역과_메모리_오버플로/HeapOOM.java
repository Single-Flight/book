
import java.util.ArrayList;
import java.util.List;
import org.openjdk.jol.info.ClassLayout;
// VM 매개 변수 : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError

public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) throws Exception {
        List<OOMObject> list = new ArrayList<OOMObject>();

        // 1. 일반 OOMObject 객체의 메모리 레이아웃 출력
        System.out.println("=== OOMObject Layout ===");
        System.out.println(ClassLayout.parseClass(OOMObject.class).toPrintable());

        // 2. OOMObject[] 배열 객체의 메모리 레이아웃 출력 (배열 헤더 확인용)
        System.out.println("=== OOMObject Array Layout ===");
        System.out.println(ClassLayout.parseClass(OOMObject[].class).toPrintable());
        while (true) {
            list.add(new OOMObject());
        }
    }
}