📦 AWS Java S3 Demo

This project is a simple Java Maven application that uses the AWS SDK for Java v2 to list all S3 buckets in your AWS account.

It is designed for AWS Cloud Developer Associate practice and demonstrates how to:

Configure AWS SDK v2

Create an S3 client

List S3 buckets

Run the program locally or on an EC2 instance

🚀 Features

Uses AWS SDK for Java v2

Demonstrates S3Client usage

Shows how AWS lists buckets across all regions

Simple and beginner-friendly Java code

🛠️ Prerequisites

Make sure you have:

Java 17+ installed

Maven installed

AWS CLI configured with valid credentials

aws configure


IAM permissions:

AmazonS3ReadOnlyAccess (minimum)

or AmazonS3FullAccess

📁 Project Structure
aws-java-s3-demo/
 ├── src/main/java/com/example/s3demo/Main.java
 ├── pom.xml
 └── README.md

📜 Code Example

Main Java file (Main.java):

package com.example.s3demo;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class Main {
    public static void main(String[] args) {
        S3Client s3 = S3Client.builder()
                .region(Region.US_EAST_1)
                .build();

        s3.listBuckets().buckets()
                .forEach(bucket -> System.out.println(bucket.name()));
    }
}

▶️ How to Run the Project (Local)

Navigate to the project folder:

cd aws-java-s3-demo


Build the project:

mvn clean package


Run the application:

mvn exec:java -Dexec.mainClass="com.example.s3demo.Main"

▶️ How to Run on EC2

SSH into your EC2 instance

Install Java & Maven (if needed)

Clone your GitHub repo:

git clone https://github.com/YOUR_USERNAME/aws-java-s3-demo.git


Build & run:

cd aws-java-s3-demo
mvn clean package
mvn exec:java -Dexec.mainClass="com.example.s3demo.Main"

🧠 Why S3 Buckets Show Across Regions?

Even if your SDK region is us-east-1, S3 buckets are global, so the AWS API always returns buckets from all regions.

📘 License

This project is for educational purposes.
Feel free to modify and reuse it.
