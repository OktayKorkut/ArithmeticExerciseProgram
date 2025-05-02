import java.util.Scanner;

public class ArithmeticExerciseProgram {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println("Welcome to Arithmetic!s Exercise Program");
        System.out.println("——————————————————————————————————————————");
        System.out.println("You have 90 seconds to answer as many questions as possible.");
        System.out.println("You will get 5 seconds bonus if you answer 5 questions in a row.");
        System.out.println("Use java arithmetic precedence rules to find answers!");
        System.out.println("Press ' q ' to quit or any key to start...");




        long startTime = System.currentTimeMillis();
        int questionNumber = 0;
        int correctAnswers = 0;
        while(System.currentTimeMillis() - startTime < 90000){
            System.out.println((System.currentTimeMillis() - startTime)/1000);
            boolean isAnswerCorrect = isAnswerCorrect(questionNumber);
            questionNumber++;

            if(isAnswerCorrect){
                correctAnswers++;
                if(correctAnswers % 5 == 0){
                    startTime -= 5000;
                }
            }

        }
    }

    public static boolean isAnswerCorrect(int questionNumber) {
        Scanner scn = new Scanner(System.in);
        int answer = 0;

        if (questionNumber<=3){
            int a=(int) (Math.random()*10);
            int b=(int) (Math.random()*10);
            int operationType=(int)(Math.random()*4);
            switch (operationType){
                case 0:
                    System.out.print("Q" + questionNumber + "    " + a + "+" + b + "= " );
                    answer = scn.nextInt();
                    if(a+b == answer){
                        System.out.print("Correct");
                        return true;

                    }
                    break;
                case 1:
                    System.out.print("Q" + questionNumber + "    " + a + "-" + b + "= " );
                    answer = scn.nextInt();
                    if(a-b == answer){
                        System.out.print("Correct");
                        return true;

                    }
                    break;
                case 2:
                    System.out.print("Q" + questionNumber + "    " + a + "*" + b + "= " );
                    answer = scn.nextInt();
                    if(a*b == answer){
                        System.out.print("Correct");
                        return true;

                    }
                    break;
                case 3:
                    System.out.print("Q" + questionNumber + "    " + a + "/" + b + "= " );
                    answer = scn.nextInt();
                    if(a/b == answer){
                        System.out.print("Correct");
                        return true;

                    }
                    break;
            }

        }else if (questionNumber>3){
            int a=(int) (Math.random()*20);
            int b=(int) (Math.random()*20);
            int c=(int) (Math.random()*20);
            int correctAnswer = 0;
            int operationType=(int)(Math.random()*4);
            int secondOperationType=(int)(Math.random()*4);
            String operationTypeFirst = getOperation(operationType);
            String operationTypeSecond = getOperation(secondOperationType);
            System.out.print("Q" + questionNumber + "    " +a + operationTypeFirst + b + secondOperationType + c);

            if(operationTypeFirst.equals("+")){
                if (operationTypeSecond.equals("+")){
                    correctAnswer = a + b + c;
                }else if (operationTypeSecond.equals("-")){
                    correctAnswer = a + b - c;
                }else if(operationTypeSecond.equals("/")){
                    correctAnswer = a + b /c;
                }else if(operationTypeSecond.equals("*")){
                    correctAnswer = a + b *c;
                }
            }
            // kalan ihtimalleri ekle

            answer = scn.nextInt();
            if(answer == correctAnswer){
                System.out.print("Correct");
                return true;
            }

        }
        return false;
    }

    public static String getOperation(int operationType){
        String operationSum = "+";
        String operationDivide = "/";
        String operationMinus = "-";
        String operationMultipy = "*";

        switch (operationType){
            case 0:
                return operationSum;
            case 1:
                return operationMinus;
            case 2:
                return operationDivide;
            case 3:
                return operationMultipy;
        }
        return "";
    }
}
