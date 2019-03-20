package com.example.sidster.apiintegration;

public class edu_output {

    private pdata data;

    public pdata getData ()
    {
        return data;
    }

    public void setData (pdata data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }
}
