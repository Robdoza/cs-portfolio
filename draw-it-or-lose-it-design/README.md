# cs-portfolio

# Draw It or Lose It - Software Design Document

## Project Overview
The Gaming Room is a client interested in developing a web-based, multi-platform version of their existing Android game, Draw It or Lose It. Design a system that can support multiple games, teams and players simultaneously while allowing for consistent behavior in distributed set environments.

Implementation Goals include the design necessitated centralized game management, strict enforcement of unique identifiers for every game, team and player as well as support for independent scalability in a distributed client server setup. The system had to function dependably under timed gameplay conditions, yet could not compromise either security or cost.

## Reflection

### What I Did Particularly Well?
My strongest contribution in this design document was to lay out architectural tradeoffs and platform recommendations clearly. I reviewed several OSs and made a case for Linux as the ideal default server OS due to scalability, cost-effectiveness, cloud support capabilities, and distributed systems supporting it.

I successfully did domain modeling using object-oriented principles. The inheritance from the Entity base class, encapsulating collections, and GameService being a Singleton are all architectural decisions, rather than coding stuff on an ad hoc basis. The UML diagram helped with visualizing the relationships, such as Game–Team and Team–Player hierarchies, keeping everything clear.

Additionally, I took a good look at storage, memory management, distributed systems and security considerations as well to demonstrate that design is more than “writing classes”, it’s about performance, reliability and the reality of deployment.

### How the Design Process Helped When Developing Code?
I learned that working through the design document before coding was a huge help in improving clarity and reducing ambiguity. Using requirements to define things that needed implementing like uniqueness enforcement or only being able to manage the object from a single center, made implementation simple, you already knew where there were constraints.

A domain model showed relationships before committing to writing class files. Also, defining inheritance and containment relationships early transformed the code design process as a matter of executing an outlined plan rather than experimental coding.

It was a design document that required thinking about scalability, concurrency and distributed deployment, things not often considered by those solely focused on functional requirements. This structured planning reduced rework and improved overall system cohesion.

### If I Could Revise One Section
If there is one section of the document that I would rework this is it, “The System Architecture View section”. The logical architecture and distributed considerations were explained later on, but a cleaner visual or layered diagram showing client-server tiers, load balancers, database interaction would have helped non-technical stakeholders during presentations.

I would also, in future models, incorporate a deployment diagram, or architectural flow diagram, to augment the UML domain model with system-level info.

### Interpreting User Needs in the Design
Interpreting user needs required translating gameplay requirements into enforceable system rules. For example, unique game and team names transitioned from a logical validation into enforced programmatic checks before creating the object. To support multiple simultaneous sessions, it was decided that session object management would be centralized using a singleton service for the objects and that distribution capabilities are recommended in deployment.

This is particularly important because software exists for the purpose of human interaction. Scaling, usability and performance factors can negatively affect the user experience even if code is technically sound. When designing with end users in mind, system constraints will facilitate clear, fair and responsive gameplay.

### My Approach to Software Design
I approached the software design systematically:


- Analyze requirements and constraints  
- Model domain entities and relationships  
- Apply object-oriented design principles  
- Evaluate deployment environments and scalability  
- Consider performance, storage, and security early  

In future work, I would continue to use structured modeling techniques such as UML diagrams, domain-driven thinking, and architectural evaluation of platform tradeoffs. I would also have a more explicit risk analysis and concurrency plan earlier in the design process.

Building software is not just choosing the tools, it’s about envisioning scale, pain points and user behaviors before you start implementing.
