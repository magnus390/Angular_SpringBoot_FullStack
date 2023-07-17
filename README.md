# Angular_SpringBoot_FullStack

**1.  Setting Up and Running the Application**

To set up and run the full-stack application, follow the steps below:

**Step 1: Clone the Repository**

Clone the repository by copying the Git URL from GitHub and running the following command in your designated folder:

```
git clone [Git URL]
```

**Step 2: Open the Editors**

Open your favorite code editor for coding. In this setup, we will use two editors:

Visual Studio Code for Angular Frontend
IntelliJ IDEA for Spring Boot Backend

**Step 3: Install Dependencies and Run the Frontend**

In Visual Studio Code, open the terminal and navigate to the frontend directory of the cloned repository. Then, perform the following steps:

Install the required Node.js modules by running the following command:
```
npm install
```
Run the frontend application using the following command:

```
ng serve
```

**Step 4: Run the Backend**

In IntelliJ IDEA, open the backend directory of the cloned repository. Ensure that you have the necessary dependencies installed and configured.

Run the Spring Boot application using your preferred method within IntelliJ IDEA.

**Step 5: Access the Application**

After completing the previous steps, you can access the full-stack application by opening your web browser and navigating to the following URL:

```
http://localhost:4200
```

**Note**

Please make sure that both the frontend and backend applications are running simultaneously for the proper functioning of the application.

Feel free to modify the code, experiment, and enhance the application according to your requirements. Happy coding!


**2.  Description**

This full-stack application is built with Angular on the front end and Spring Boot on the back end. The front end runs on port 4200, while the back end runs on port 8080.

When you run the application, you'll be presented with a form that includes the following fields:

1.  Age<br/>
2.  Driving Experience<br/>
3.  Driver Record<br/>
4.  Claims<br/>
5.  Car Value<br/>
6.  Annual Mileage<br/>
7.  Insurance History<br/>
The form also includes a dropdown menu populated with various car models. Please note that a large number of car models may take 1-2 seconds for the website to load.

In the Angular front end, I have implemented validations for empty fields and values less than 0.

Once you fill out the form and press the submit button, all the form data will be sent to the Spring Boot backend service. The backend will perform calculations based on the conditions specified in the PDF document.

After the calculations are complete, the backend will return the premium as a response. After submitting the form, you will see three fields displayed:

Annual Premium
Monthly Premium
Quote Reference
These values will be shown to you upon pressing the submit button.
