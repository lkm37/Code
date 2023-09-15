/**
 * A counter that will roll over to the min
 * value when attempting to increase it beyond the maximum value and to the max 
 * value when attempting to decrease it below the min value
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter
{
    private int counter;
    private int min;
    private int max;
    private boolean rolledOver = false;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        min = 0;
        max = Integer.MAX_VALUE;
        counter = 0;
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
        if(min<max){
            this.min = min;
            this.max = max;
            counter = min;
        }
        else{
            throw new CounterInitializationException("Minimum must be less than maximum.");
        }
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    @Override
    public boolean equals(Object otherObject)
    {
        boolean result = false;
        if (otherObject instanceof Counter)
        {
            Counter otherCounter = (Counter)otherObject;
            if(otherCounter.value()==counter&&otherCounter.getMax()==max&&otherCounter.getMin()==min&&rolledOver==otherCounter.rolledOver()){
                result = true;
            }
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        if(counter==max){
            counter=min;
            rolledOver=true;
        }else{
            counter++;
            rolledOver=false;
        }
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        if(counter==min){
            counter=max;
            rolledOver=true;
        }else{
            counter--;
            rolledOver=false;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        return counter;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        boolean result = false;
        if(rolledOver&&(counter==min||counter==max)){
            result = true;
        }
        return result;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        return "Counter: value="+counter+" min="+min+" max="+max+" rolled over="+rolledOver();		
    }
    public int getMax(){
        return max;
    }
    public int getMin(){
        return min;
    }
    public void setMax(int max){
        this.max=max;
    }
    public void setMin(int min){
        this.min=min;
    }
 
}
