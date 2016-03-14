package Array;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhijeet on 3/1/16.
 * https://www.interviewbit.com/problems/first-missing-integer/
 * Given an unsorted integer array, find the first missing positive integer.

 Example:

 Given [1,2,0] return 3,

 [3,4,-1,1] return 2,

 [-8, -7, -6] returns 1

 Your algorithm should run in O(n) time and use constant space.

 one solution with detail explanation:
 http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/

 */
public class FindMissingInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(190, 831, 510, 35, 441, 671, 759, 558, 752, 988, 788, 285, 566, 951, 778, 776, 468, 75, 312, 189, 18, 870, 475, 127, 542, 643, 611, 245, 202, 204, 823, 874, 856, 6, 538, 425, 882, 696, 626, 647, 984, 50, 275, 894, 97, 873, 740, 494, 276, 256, 907, 533, 389, 737, 112, 932, 994, 164, 129, 326, 171, 16, 433, 531, 632, 548, 898, 29, 733, 607, 484, 434, 523, 677, 471, 783, 729, 726, 334, 158, 627, 596, 237, 125, 580, 661, 817, 790, 179, 573, 273, 700, 346, 268, 919, 690, 88, 605, 634, 0, 274, 763, 549, 356, 990, 651, 795, 106, 640, 393, 869, 363, 938, 829, 503, 518, 857, 301, 920, 950, 240, 411, 770, 214, 133, 593, 886, 723, 924, 435, 194, 74, 381, 669, 728, 62, 754, 416, 745, 657, 935, 387, 653, 836, 347, 888, 91, 586, 903, 136, 818, 130, 134, 139, 997, 896, 172, 295, 76, 259, 591, 620, 224, 13, 717, 372, 330, 965, 166, 555, 864, 923, 266, 667, 31, 469, 267, 77, 25, 344, 645, 743, 464, 680, 260, 160, 735, 191, 610, 338, 117, 629, 422, 996, 254, 712, 688, 373, 916, 410, 734, 359, 362, 423, 323, 299, 460, 520, 847, 308, 764, 585, 583, 26, 253, 417, 345, 466, 205, 236, 543, 594, 899, 228, 942, 336, 341, 86, 980, 461, 802, 105, 604, 439, 865, 947, 473, 40, 952, 670, 750, 223, 463, 808, 284, 291, 785, 141, 987, 44, 825, 819, 701, 912, 82, 317, 289, 48, 867, 635, 213, 415, 121, 61, 613, 528, 799, 534, 108, 584, 250, 57, 993, 353, 307, 429, 131, 124, 530, 964, 90, 998, 150, 842, 27, 983, 305, 646, 827, 64, 132, 233, 182, 849, 731, 298, 109, 890, 446, 453, 689, 452, 192, 659, 162, 976, 824, 199, 38, 905, 861, 488, 793, 601, 751, 893, 367, 349, 173, 564, 660, 522, 902, 159, 352, 953, 322, 66, 806, 926, 406, 314, 877, 512, 104, 264, 511, 936, 652, 459, 400, 716, 948, 921, 221, 925, 900, 800, 198, 855, 476, 375, 243, 828, 851, 801, 215, 685, 631, 527, 786, 100, 229, 719, 332, 354, 296, 897, 180, 465, 319, 500, 551, 711, 775, 860, 283, 8, 208, 327, 978, 395, 837, 576, 402, 915, 455, 612, 42, 773, 153, 606, 177, 320, 376, 999, 972, 929, 766, 599, 169, 442, 934, 622, 380, 394, 89, 706, 913, 695, 457, 186, 351, 746, 559, 39, 547, 49, 617, 258, 609, 779, 961, 846, 708, 815, 2, 46, 931, 505, 679, 519, 546, 911, 487, 859, 102, 959, 370, 156, 419, 628, 58, 154, 440, 52, 841, 979, 830, 872, 120, 486, 678, 739, 772, 470, 535, 713, 517, 364, 448, 414, 257, 412, 313, 185, 742, 279, 526, 246, 642, 176, 222, 637, 244, 398, 293, 443, 638, 10, 852, 73, 454, 683, 47, 288, 858, 123, 368, 328, 524, 967, 110, 374, 941, 747, 225, 710, 794, 658, 409, 403, 450, 280, 211, 297, 578, 247, 175, 755, 114, 479, 803, 889, 391, 502, 812, 116, 392, 552, 22, 636, 101, 19, 602, 589, 633, 986, 572, 544, 571, 939, 384, 271, 871, 56, 206, 430, 405, 514, 277, 957, 826, 545, 424, 242, 691, 178, 496, 974, 603, 707, 732, 592, 832, 365, 665, 810, 265, 848, 449, 300, 686));
        System.out.println(solution.firstMissingPositive(arrayList));
    }
    public static class Solution {
        private int separatePositiveAndNegativeNumbers(ArrayList<Integer> a) {
            int i = 0;
            for(int j=0; j < a.size(); j++) {
                if (a.get(j) < 0) {
                    Collections.swap(a, i, j) ;
                    i++;
                }
            }
            return i;
        }

        private void removeZeros(ArrayList<Integer> a) {
            for(int i= 0 ; i < a.size(); i++) {
                if(a.get(i) == 0) {
                    a.remove(i);
                }
            }
        }


        public int firstMissingPositive(ArrayList<Integer> a) {
            // remove all zeros
            removeZeros(a);

            // move all the negative numbers to be beginning of the array
            int beginIndex = separatePositiveAndNegativeNumbers(a);

            for(int i = beginIndex; i < a.size(); i++) {
                if(beginIndex + Math.abs(a.get(i)) - 1 < a.size() && a.get(beginIndex + Math.abs(a.get(i)) - 1) > 0 ) {
                    a.set(beginIndex +Math.abs(a.get(i)) - 1,  -1 * a.get(beginIndex + Math.abs(a.get(i)) - 1));

                }
                System.out.println("array: "  + Arrays.toString(a.toArray()));
            }

            for (int i = 0; i < a.size(); i++) {
                if(a.get(i) > 0) {
                    return i+1 - beginIndex;
                }
            }
            return a.size()+1 - beginIndex;
        }
    }


}
