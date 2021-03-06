package com.machineLearning;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    private static TrainingResult trainingResult;
    public final static String LANGUAGE = "EN";
    private static boolean optimize = true;
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File trainingFile = (new File(LANGUAGE + "/train.txt"));

        Training trainingData = new Training(trainingFile, optimize);
        trainingResult = trainingData.getTrainingResult();


        File testFiles = new File(LANGUAGE + "/" + LANGUAGE+ ".in");


        /*Class Test_k produces k-th best sequence for the input data.
        Constructor for Test_k takes in parametes: TrainingResult obj, integer k (for k-th best sequence)
        */

//        Test test = new Test(trainingResult, optimize);
//        test.writePrediction(testFiles, PredictionAlgorithm.VITERBI);
        Test_k test = new Test_k(trainingResult,5,optimize);
        //This Method predicts the sequence using Viterbi algorithm and writes the result to file
        test.writePrediction(testFiles);
    }

    public static void printEmission(Map<EmissionNode, Integer> map) {
        for (Map.Entry<EmissionNode, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }
    public static void printTransition(Map<TransitionNode, Integer> map) {
        for (Map.Entry<TransitionNode, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

    public static void printLabel(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }
}
