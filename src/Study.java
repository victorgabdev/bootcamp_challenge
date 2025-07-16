public class Study {
    public static void main(String[] args) {

        var person = new Person("Victor", 12);
        System.out.println(person.name());

        // POLIMORFISMO
        Object name = "Victor";
        //name.toUpperCase();

        String name2 = "Victor";
        var name3 = name2.toUpperCase();
    }
}
