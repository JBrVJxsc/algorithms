algorithms
==========

A project which can save your time and organize your code on the way learning algorithms.

### What will you get?
    For learners with Java programming experience:
        You can save your time wasted on creating project or editing only one class over and over agian, and keep focus on implementing algorithms.
    For total new Java learners:
        Besides the time-saving you will get above, you can learn a little bit about Extending, Implementing, Thread, Event, Generic, Abstract Class, and Interface, by cracking my code.

### How to use this project?
    1.You should open this project in IntelliJ IDEA. Get IDEA: http://www.jetbrains.com/idea/.(However, you may convert the project to the format which can be opened by Eclipse by yourself).
    2.Create your own class implementing algorithm, then extend the BaseAlgorithm and implement the IAlgorithm.
    
### Sample
    public class Sample extends BaseAlgorithm implements IAlgorithm {
    
        @Override
        public long getID() {
            //Get new ID by running the Common Commands. It is in the bottom of the combobox when running the project.
            //Bigger ID, topper in the combobox.
            return 1400424368641l;
        }
    
        @Override
        public String getName() {
            //This name will be shown in the combobox.
            return "Sample Name";
        }
    
        @Override
        public String getSummary() {
            //This summary will be shown in the console area of the main form.
            return "Sample Summary";
        }
    
        @Override
        public void run() {
            //Every algorithm runs in this method.
    
            //Print everything you want to print, by using only one method: print;
            print("Everything you want to print.");
            //Print Object.
            Object object = new Object();
            print(object);
            //Print Array.
            int[] array = new int[10];
            print(array);
            //Print ArrayList.
            ArrayList<Point> arrayList = new ArrayList<Point>();
            print(arrayList);
            //Print \n.
            print();
    
            //Asking for a run-time parameter setting, by using method: set.
            int defaultNumberOfPoints = 10;
            String defaultMessage = "The number of points is: ";
            Parameter<Integer> integerParameter = new Parameter<Integer>(defaultNumberOfPoints, "Number of Points");
            Parameter<String> stringParameter = new Parameter<String>(defaultMessage, "Message");
            //Show the parameter setting form.
            set(integerParameter);
            set(stringParameter);
            //Use the parameter by their getValue method..
            print(integerParameter.getValue());
            print(stringParameter.getValue());
    
            //Show a message box, by using method: show.
            String message = stringParameter.getValue() + integerParameter.getValue();
            show("Message is: " + message);
    
            //Set timer. Timer bases on the stack, so you can nest the timer in another timer scope.
            //Set timer on.
            timerOn();
            timerOn();
            timerOn();
            //Set timer off.
            print("3 th Timer off. Time has past " + timerOff() + " ms.");
            print("2 th Timer off. Time has past " + timerOff() + " ms.");
            print("1 th Timer off. Time has past " + timerOff() + " ms.");
        }
    }
