package com.example.sidster.apiintegration;

public class prof_output {

    private profdata data;

    public profdata getData ()
    {
        return data;
    }

    public void setData (profdata data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }



}
