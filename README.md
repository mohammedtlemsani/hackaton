# HealthChain Hackathon Project

## Context
This project is developed within the N7Challenge hackathon organized by ENSET Mohammedia and the N7Geeks club. The aim of the hackathon is to explore and utilize web3 and AI technologies within the Moroccan context, fostering innovation and collaboration among participants.


## Overview

Welcome to our HealthChain hackathon project! This application leverages blockchain technology, IPFS (InterPlanetary File System), and smart contracts to securely manage and share medical records. The goal is to provide patients and healthcare providers with a decentralized, transparent, and efficient system for storing and accessing sensitive health data.

## Features

- **Secure Record Storage**: Upload medical records to IPFS and store their hash on the Ethereum blockchain using smart contracts.
  
- **Encryption**: Encrypt medical using EAS Algorithm records before uploading to IPFS to ensure privacy and security.
  
- **Blockchain Integration**: Utilize smart contracts to manage interactions between the frontend, backend, IPFS, and Ethereum blockchain.
  
- **User Authentication**: Implement a login system to authenticate users and control access to medical records.
  
- **Medical Record Management**: Allow users to add, view, and manage their medical records through a user-friendly interface.
  
- **Predictive Analytics**: Incorporate machine learning predictions (XGBoost) based on medical data for personalized healthcare insights.

## Tech Stack

- **Frontend**: Angular for building the user interface and enabling interactions with the backend.
  
- **Backend**: Spring Boot to handle business logic, encryption, IPFS interactions, and Ethereum transactions.
  
- **IPFS**: Distributed file system used for storing encrypted medical records and retrieving them via unique hashes.
  
- **Blockchain**: Ethereum blockchain for storing hashes of medical records and executing smart contracts.
  
- **Smart Contracts**: Solidity for writing smart contracts, deployed using Truffle and interacting with Web3.js.
  
- **Web3j**: Java library for integrating Java applications with Ethereum clients.
  
- **Metamask**: Browser extension for interacting with the Ethereum blockchain and signing transactions securely.

## Getting Started

1. **Prerequisites**:
   - Install Node.js, Angular CLI, Java, and Spring Boot.
   - Set up Ganache for local Ethereum development and install Metamask.
   - Configure IPFS node or use a public IPFS gateway.
   
2. **Installation**:
   - Clone this repository.
   - Install frontend dependencies: `cd frontend && npm install`
   - Install backend dependencies: `cd backend && mvn install`
   
3. **Configuration**:
   - Configure Metamask with your local Ganache network.
   - Set up IPFS node connection details in the backend application properties.

4. **Running the Application**:
   - Start the frontend: `cd frontend && ng serve`
   - Start the backend: `cd backend && mvn spring-boot:run`

5. **Access**:
   - Open your browser and navigate to `http://localhost:4200` to access the frontend.

## Contributors

- Baraka Khaoula
- Mohammed Amine Badri
- Tlemsani Mohammed

