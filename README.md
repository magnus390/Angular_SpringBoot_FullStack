# Angular SpringBoot FullStack

Welcome to the Angular SpringBoot FullStack application! This is a Full Stack application built with Angular on the Frontend and Spring Boot on the Backend. It features a form where users can input their details, and based on that, the application calculates the premium.

Let's dive into the details:

**1.  Setting Up and Running the Application**<br/>
**2.  Description**<br/>
**3.  Challenges and Key Features**<br/>
**4.  Output**  <br/><br/><br/>

**1.  Setting Up and Running the Application**

To set up and run the full-stack application, follow the steps below:

**Step 1: Clone the Repository**

Clone the repository by copying the Git URL from GitHub and running the following command in your designated folder:

```
git clone git@github.com:magnus390/Angular_SpringBoot_FullStack.git
```

**Step 2: Open the Editors**

Open your favorite code editor for coding. In this setup, we will use two editors:

Visual Studio Code for Angular Frontend
IntelliJ IDEA for Spring Boot Backend

**Step 3: Install Dependencies and Run the Frontend**

In Visual Studio Code, open the terminal and navigate to the Frontend directory of the cloned repository. Then, perform the following steps:

Install the required Node.js modules by running the following command:
```
npm install
```
Run the Frontend application using the following command:

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

Please make sure that both the Frontend and Backend applications are running simultaneously for the proper functioning of the application.


**2.  Description**

The Frontend runs on port 4200, while the Backend runs on port 8080.

When you run the application, you'll be presented with a form that includes the following fields:

1.  Age<br/>
2.  Driving Experience<br/>
3.  Driver Record<br/>
4.  Claims<br/>
5.  Car Value<br/>
6.  Annual Mileage<br/>
7.  Insurance History

The form also includes a dropdown menu populated with various car models. Please note that a large number of car models may take 1-2 seconds for the website to load.

In the Angular Frontend, I have implemented validations for empty fields and values less than 0.

Once you fill out the form and press the submit button, all the form data will be sent to the Spring Boot Backend service. The Backend will perform calculations based on the conditions specified in the PDF document.

After the calculations are complete, the Backend will return the premium as a response. After submitting the form, you will see three fields displayed:

Annual Premium
Monthly Premium
Quote Reference
These values will be shown to you upon pressing the submit button.

**3. Challenges and Key Features**

During the development of this application, I encountered minimal challenges due to prior experience in designing similar applications. Some of the key features are mentioned below:-

Data Transmission: Implementing the data transmission between the Frontend and Backend was an interesting task. Ensuring seamless communication and transferring the form data accurately were essential considerations. I have used CrossOrigin functionality to catch the request based on the port mentioned in the SpringBoot application.

Form Validations: Implementing form validations within the Frontend was crucial to ensure data integrity and provide a seamless user experience. This involved validating empty input fields, less than 0 validation, and providing informative error messages.


**4.  Output**

**Form**<br/><br/>
![1](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/65d3b836-111d-4969-ae2b-f22348bd663b)  <br/><br/>

**Empty Field Validation**<br/><br/>
![2](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/e92a41cc-f383-4b71-8193-90ff71830936)  <br/><br/>

**Less than 0 field Validation**<br/><br/>
![3](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/269db96d-0d92-4190-9827-edd93d0ab1c7)  <br/><br/>

**Populating Car Models Dropdown**<br/><br/>
![4](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/131e05f5-c5c8-4480-8a61-0c7487c640ac)  <br/><br/>

**Obtaining annual and monthly premium with Quote Reference**<br/><br/>
![5](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/85a3440b-a181-43f7-b279-80976dcda5a7)  <br/><br/>

**Unknown field Output**<br/><br/>
Factor field is unknown(???) for Car Value = 200,000<br/><br/>
![6](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/08801e95-87f5-4add-a2e8-d77e05f64235)  <br/><br/>

**Postman Output**<br/><br/>
A response message with 3 fields - *success, premium, quoteReference*
![7](https://github.com/magnus390/Angular_SpringBoot_FullStack/assets/30699194/9ddaab38-57dd-4356-abff-5722f6cb2331)
