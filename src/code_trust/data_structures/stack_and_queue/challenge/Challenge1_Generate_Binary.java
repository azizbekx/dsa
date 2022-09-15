package code_trust.data_structures.stack_and_queue.challenge;

import code_trust.data_structures.stack_and_queue.QueueImpl;

public class Challenge1_Generate_Binary {
    public static String[] findBin(int number){
        String[] result = new String[number];
        QueueImpl<String> queue = new QueueImpl<String>(number+1);

        queue.enqueue("1");

        for(int i=0; i<number; i++){
            result[i] = queue.dequeue(); //"1"
            String s1 = result[i] + "0"; //"10"
            String s2 = result[i] + "1"; //"11"

            queue.enqueue(s1);
            queue.enqueue(s2);
        }
        return result;
    }

}
