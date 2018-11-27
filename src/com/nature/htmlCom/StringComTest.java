package com.nature.htmlCom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.FileUtils;

public class StringComTest
{


	public static void main(String[] args)
	{
		String filePath = "/Users/apple/Desktop/02_223618_929 2.htm";
		try
		{
			File outFile = new File("/Users/apple/Desktop/02_223618_929.htm");
			if(!outFile.exists())
			{
				outFile.createNewFile();
			}
			
			System.out.println(FileUtils.readFileToString(new File(filePath),"utf-8"));
			FileUtils.writeStringToFile(outFile,
					HtmlCompressor.compress(FileUtils.readFileToString(new File(filePath),"utf-8")));
			System.out.println("AAA");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
