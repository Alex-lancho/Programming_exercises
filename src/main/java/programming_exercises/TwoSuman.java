package programming_exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

* */
public class TwoSuman {

    public int[] twoSum(int[] nums, int target) {
        int mayor=0;
        int indiceMayor=0;
        int menor=9;
        int indiceMenor=0;
        Map<Integer, Integer> menores =  new HashMap<>();

        int i=0;

        for(int num:nums){
            if(num<=target){
                menores.put(i,num);
            }
            i++;
        }

        for (Map.Entry<Integer, Integer> entry : menores.entrySet()) {
            int valor = entry.getValue();
            int clave = entry.getKey();

            if (mayor < valor) {
                mayor = valor;
                indiceMayor = clave;
            }

            if (valor < menor) {
                menor = valor;
                indiceMenor = clave;
            }
        }
        int []salida = new int[2];
        for (Map.Entry<Integer, Integer> entry : menores.entrySet()) {
            int valor = entry.getValue();

            if ((menor + valor) == target) {
                salida[0]=indiceMenor;
                salida[1]=entry.getKey();
                break; //
            } else if ((mayor + valor) == target) {
                salida[0]=indiceMayor;
                salida[1]=entry.getKey();
                break;
            }
        }
        return salida;
    }
}

class Main{
    public static void main(String[] args) {
        TwoSuman twoSuman = new TwoSuman();

        System.out.println(Arrays.toString(twoSuman.twoSum(new int[]{3,3}, 6)));
    }
}
