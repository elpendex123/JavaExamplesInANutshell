package com.coello.chapter06;

import java.io.File;

public class Delete {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Delete <file or directory>");
            System.exit(0);
        }

        try
        {
            delete(args[0]);
        }
        catch (IllegalArgumentException iae)
        {
            System.err.println(iae.getMessage());
        }
    }

    public static void delete(String filename)
    {
        File f = new File(filename);

        if (!f.exists())
            fail("Delete: no such file or directory: " + filename);

        if (!f.canWrite())
            fail("Delete: write protected: " + filename);

        if (f.isDirectory())
        {
            String[] files = f.list();

            if (files.length > 0)
                fail("Delete: directory not empty: " + filename);
        }

        boolean success = f.delete();

        if (!success)
            fail("Delete: deletion failed");
    }

    public static void fail(String msg) throws IllegalArgumentException
    {
        throw new IllegalArgumentException(msg);
    }
}
