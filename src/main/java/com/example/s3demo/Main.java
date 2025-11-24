package com.example.s3demo;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class Main {
    public static void main(String[] args) {
// Create S3 client in us-east-1
        S3Client s3 = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
/*
        S3Client s3 = S3Client.builder()
                .region(Region.US_EAST_2)
                .build();

 */

        try {
            ListBucketsResponse response = s3.listBuckets();
            System.out.println("Your S3 buckets:");
            response.buckets().forEach(bucket -> {
                System.out.println("- " + bucket.name());
            });
        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
    }
}
