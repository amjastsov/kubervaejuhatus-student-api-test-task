# Getting Started with the Spring Boot Application

## Important

- Java 17 installed and configured in your IDE
- Node.js and Yarn installed (`yarn` command available in terminal)

## Setup Instructions

1. **Clone the repository**

2. **Set Java version to 17**

3. **Install packages with** `yarn install`
4. **Build the Spring application**

Use the build.gradle file located at: `studentapi/build.gradle`

5. **Run the application**

Launch the main class:
`StudentApiApplication`

6. **Set API URL for tests and run them**

- Windows
   ```cmd
   setx API_URL "http://localhost:8080"
   yarn test
   ```
- On Linux
    ```
    API_URL="http://localhost:8080" yarn test
    ```
