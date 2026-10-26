## Grazioso Salvare Dashboard Project

For this project, I developed an interactive dashboard for Grazioso Salvare, an organization that identifies dogs suitable for search-and-rescue training. The application uses Python, MongoDB, and Dash to retrieve, filter, and visualize animal shelter data. The dashboard allows users to filter animals based on different rescue categories, view matching records in a data table, and explore the results through a pie chart and interactive map.

This project helped me better understand how databases and applications work together to provide useful information to users.

### How do I write programs that are maintainable, readable, and adaptable?

When writing programs, I try to keep my code organized, readable, and easy to modify. One way I accomplished this was by developing a separate Python CRUD module in Project One. This module handles the database operations, including creating, reading, updating, and deleting records in MongoDB.

In Project Two, I reused this module to connect my dashboard to the database instead of writing the database queries directly into the dashboard code. This made the application easier to organize because the database operations and user interface were handled separately.

One advantage of this approach is that I can modify the database functionality without having to rewrite the entire dashboard. I could also reuse the CRUD module in future projects, such as another web application that needs to retrieve or manage MongoDB records.

## How do I approach a problem as a computer scientist?

When approaching a problem, I start by understanding what the client needs and determining how the software can meet those requirements. For the Grazioso Salvare project, I needed to create a dashboard that could identify potential search-and-rescue dogs based on specific characteristics, including breed, age, and sex.

I began by working with the MongoDB database and developing the CRUD functionality needed to access the animal shelter records. After completing that portion, I focused on connecting the database to the dashboard and implementing the required filters and visualizations.

This project was different from some of my previous assignments because I had to connect multiple components rather than focus on a single program or feature. I needed to consider how the database, Python module, and dashboard would communicate with one another.

In future projects, I would continue breaking larger problems into smaller tasks, testing each component individually, and verifying that the final application meets the client’s requirements. I would also consider database organization and indexing to help improve performance when working with larger datasets.

## What do computer scientists do, and why does it matter?

Computer scientists develop solutions to problems using technology, programming, and logical reasoning. Their work can involve developing applications, managing databases, improving existing systems, and finding ways to make processes more efficient.

The Grazioso Salvare project demonstrates how software can help an organization make better use of its data. Instead of manually searching through thousands of animal shelter records, users can apply filters to quickly identify dogs that meet specific search-and-rescue requirements.

The dashboard also presents information through visualizations, making the results easier to understand. This allows Grazioso Salvare to spend less time searching through records and more time evaluating potential rescue dogs.

Working on this project helped me recognize how important it is to develop software that not only functions correctly but also provides practical value to the people using it.
