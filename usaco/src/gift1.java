/*
ID: bapuni1
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class gift1 {
    private static String inputFile = "gift1.in";
    private static String outputFile = "gift1.out";

    private static class Member {
        public String name;
        public int initialMoney;
        public int money;
        public int gift_receivers_count;
        public String[] receivers;
    }

    public static void main(String[] args) {
        HashMap<String, Member> group = new HashMap<String, Member>();
        ArrayList<String> nameOrder = new ArrayList<String>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(inputFile);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Save the member names
            String line = bufferedReader.readLine();
            for (int i = 1; i <= Integer.parseInt(line); i++) {
                Member member = new Member();
                member.name = bufferedReader.readLine();
                member.money = 0;
                group.put(member.name, member);
                nameOrder.add(member.name);
            }

            while ((line = bufferedReader.readLine()) != null) {
                Member member = group.get(line);
                // read the money and how many groups
                line = bufferedReader.readLine();
                String[] tokens = line.split("\\s+");

                member.initialMoney = Integer.parseInt(tokens[0]);
                member.gift_receivers_count = Integer.parseInt(tokens[1]);

                // If the member have non zero receiver then share the gifts
                if (member.gift_receivers_count != 0) {
                    int giftAmount = member.initialMoney / member.gift_receivers_count;

                    for (int i = 1; i <= member.gift_receivers_count; i++) {
                        line = bufferedReader.readLine();
                        group.get(line).money += giftAmount;
                    }
                    member.money += member.initialMoney - (giftAmount * member.gift_receivers_count);
                }
            }

            bufferedReader.close();

            // flush the result
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedOutputStream = new BufferedWriter(fileWriter);

            for (String key : nameOrder) {
                String result = key + " " + (group.get(key).money - group.get(key).initialMoney + "\n");
                bufferedOutputStream.write(result);
            }
            bufferedOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
