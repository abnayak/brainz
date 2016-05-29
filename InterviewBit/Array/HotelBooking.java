package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 https://www.interviewbit.com/problems/hotel-bookings-possible/

 A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

 Input:

 First list for arrival time of booking.
 Second list for departure time of booking.
 Third is K which denotes count of rooms.

 Output:
 A boolean which tells whether its possible to make a booking.
 Return 0/1 for C programs.
 O -> No there are not enough rooms for N booking.
 1 -> Yes there are enough rooms for N booking.
 Example :

 Input :
 Arrivals :   [1 3 5]
 Departures : [2 6 8]
 K : 1

 Return : False / 0
 At day = 5, there are 2 guests in the hotel. But I have only one room.

 Solution:
 1. Sort both the depart and arrival array
 2. Lowest element in arrival is the start index, and highest element in the depart array is the end index
 3. Increase the booked room by one when encounter arrival and lower by one when encounter the depart.
 NOTE: There can by multiple departs and arrival at the same day. Check line# 66 and 61 to handle this case.

 */
public class HotelBooking {
    public static void main (String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(47, 4, 0, 12, 47, 31, 15, 49, 29, 33, 7, 22, 26, 24, 16));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(95, 4, 26, 16, 51, 79, 43, 58, 32, 80, 30, 27, 29, 54, 16));
        System.out.printf("Is booking possible: " + solution.hotel(arrive, depart, 10));
    }

    public static class Solution {
        public boolean hotel (ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
            Collections.sort(arrive);
            Collections.sort(depart);

            int begin = arrive.get(0);
            int end = depart.get(depart.size() - 1);
            int booked = 0;

            int arrivalIndex = 0;
            int departureIndex = 0;

            for (int i = begin; i <= end; i++) {
                while (arrivalIndex < arrive.size() && arrive.get(arrivalIndex) == i) {
                    booked++;
                    arrivalIndex++;
                }

                while (departureIndex < depart.size() && depart.get(departureIndex) == i) {
                    if (booked >= 1)
                        booked--;
                    departureIndex++;
                }

                if(booked > K) {
                    return false;
                }
            }
            return true;
        }
    }
}
