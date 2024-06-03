package com.example.StaffHolidays;

import com.example.StaffHolidays.*;
import com.example.StaffHolidays.util.DayTravel;
import com.example.StaffHolidays.util.TimeInterval;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TravelPlan {
    private Trip trip;
    private List<DayTravel> travelPlan;

    public TravelPlan() {
        this.travelPlan = new ArrayList<>();
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    private List<Attraction> getAttractions() {

        return this.trip.getTouristAttraction();

    }

    private boolean intersectTimetableAttraction(Attraction atr1, Attraction atr2)
    {
        TimeInterval timeAtr1 = atr1.getTimetable();
        TimeInterval timeAtr2 = atr2.getTimetable();

        return  timeAtr1.getValue1().isBefore(timeAtr2.getValue2()) && timeAtr1.getValue1().isAfter(timeAtr2.getValue1()) ||
                timeAtr1.getValue2().isBefore(timeAtr2.getValue2()) && timeAtr1.getValue2().isAfter(timeAtr2.getValue1());
    }

    private int[] dfs(int startNode, int length, int [][]adjacencyMatrix, List<Attraction> attractions)
    {
        int []colors = new int[length];
        boolean []visited = new boolean[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;
        colorNode(startNode,length,colors,adjacencyMatrix);


        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            for (int adjacentNode = 0; adjacentNode < length; adjacentNode++) {
                if (adjacencyMatrix[currentNode][adjacentNode] == 1 && !visited[adjacentNode]) {
                    stack.push(adjacentNode);
                    visited[adjacentNode] = true;
                    colorNode(adjacentNode,length,colors,adjacencyMatrix);
                }
            }
        }

        return colors;
    }

    private void printColors(int []colors) {
        System.out.println("Node\tColor");
        for (int i = 0; i < colors.length; i++) {
            System.out.println(i + "\t" + colors[i]);
        }
    }

    private void colorNode(int node, int length, int []colors, int [][]adjacencyMatrix) {
        for (int color = 1; color <= length; color++) {
            if (isColorValid(node, color, colors, adjacencyMatrix, length)) {
                colors[node] = color;
                return;
            }
        }
    }

    private boolean isColorValid(int node, int color, int []colors, int [][]adjacencyMatrix, int length) {
        for (int i = 0; i < length; i++) {
            if (adjacencyMatrix[node][i] == 1 && colors[i] == color) {
                return false;
            }
        }
        return true;
    }

    public void setTravelPlan() {
            List<Attraction> attractions = this.getAttractions();
            int length = attractions.size();
            int [][]adjacencyMatrix = new int[length][length];
            int indexAttractionOne = 0;
            int indexAttractionTwo;
            for (Attraction attraction1 : attractions)
            {
                indexAttractionTwo=0;
                for (Attraction attraction2: attractions)
                {
                    if(!attraction1.equals(attraction2))
                        if (!intersectTimetableAttraction(attraction1, attraction2))
                            adjacencyMatrix[indexAttractionOne][indexAttractionTwo] = adjacencyMatrix[indexAttractionTwo][indexAttractionOne] = 1;
                    indexAttractionTwo++;
                }
                indexAttractionOne++;
            }


            int [] colors = dfs(0,length,adjacencyMatrix,attractions);
            int currentColor = 1;
            List<Attraction> currentAttractions = new ArrayList<>();

            for (int i = 0 ; i < length; i++)
            {
                if(currentColor == colors[i])
                {
                    currentAttractions.add(attractions.get(i));
                    currentColor++;
                }
            }

            DayTravel travelPlanByDay = new DayTravel(currentAttractions);
            this.travelPlan.add(travelPlanByDay);
            //based on the matrix do a dfs travers and color the graph
            //after traverse the coloring of the graph and print nodes with different color

    }

    public List<Attraction> getTrip() {

        List<Attraction> attractions = new ArrayList<>();
        for (DayTravel travelPlan : this.travelPlan) {

            attractions.addAll(travelPlan.getValue2());
        }

        return attractions;
    }


}
