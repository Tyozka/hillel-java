package HomeWork7;

/**
 * Created by Влад on 20.06.2017.
 */
public class TestContainerInt{
    public static void main(String[] args) {
        ContainerInt cont = new ContainerInt(2);
        cont.add(4).add(5).add(5).add(5).add(5).add(5)
        .add(23)
                .add(23)
                .add(34)
                .add(2)
                .add(56)
                .add(76)
                .add(8)
        .add(34);
        cont.sort();
        cont.sort(false);
        cont.addAll(new ContainerInt(23).add(23).add(111).add(222).add(333));

        System.out.println(cont.getSize());


    }
}
