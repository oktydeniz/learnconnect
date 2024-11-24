package com.odeniz.learnconnect.boot

import com.odeniz.learnconnect.entity.Video
import com.odeniz.learnconnect.local.AppDatabase

object CourseVideosInitializer {
    fun initialize(database: AppDatabase) {
        val videoList = listOf(
            Video(
                id = 1,
                courseId = 12,
                title = "Introduction to Java Programming",
                url = "https://www.youtube.com/watch?v=2dZiMBwX_5Q",
                duration = 600,
                about = "Learn the fundamentals of Java programming, including its purpose, use cases, and how to set up your development environment. Understand why Java remains a top programming language for developers.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/java_intro.png"
            ),
            Video(
                id = 2,
                courseId = 12,
                title = "Setting Up Your IDE for Java",
                url = "https://www.youtube.com/watch?v=drQK8ciCAjY",
                duration = 900,
                about = "A step-by-step guide on how to install and set up a Java Integrated Development Environment (IDE), such as IntelliJ IDEA or Eclipse. Learn to configure your workspace for maximum efficiency.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/java_ide_setup.png"
            ),
            Video(
                id = 3,
                courseId = 12,
                title = "Java Syntax and Basic Constructs",
                url = "https://www.youtube.com/watch?v=b5l5UodFzMo",
                duration = 1200,
                about = "Dive into Java's syntax, learning about variables, data types, and control flow statements such as if-else, switch, and loops. Build a strong foundation in writing Java code effectively.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/java_syntax.png"
            ),
            Video(
                id = 4,
                courseId = 12,
                title = "Object-Oriented Programming in Java",
                url = "https://www.youtube.com/watch?v=TiccevwEVe8",
                duration = 1800,
                about = "Explore the core concepts of object-oriented programming (OOP) in Java, such as classes, objects, inheritance, polymorphism, and encapsulation. Understand how to design reusable and maintainable code.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/java_oop.png"
            ),
            Video(
                id = 5,
                courseId = 12,
                title = "Exception Handling and Debugging in Java",
                url = "https://www.youtube.com/watch?v=1XAfapkBQjk",
                duration = 1500,
                about = "Learn how to handle exceptions and errors in Java using try-catch blocks, throw statements, and custom exceptions. Master debugging techniques to troubleshoot and improve your code quality.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/java_exceptions.png"
            ),
            Video(
                id = 6,
                courseId = 12,
                title = "Building Your First Java Project",
                url = "https://www.youtube.com/watch?v=6WYJLkd3R9M",
                duration = 2100,
                about = "Put your knowledge into practice by building a simple Java project from scratch. Learn how to organize your code, create classes, and use packages effectively.",
                order = 6,
                thumbnailUrl = "https://example.com/thumbnails/java_project.png"
            ),
            Video(
                id = 11,
                courseId = 13,
                title = "Introduction to Python Programming",
                url = "https://www.youtube.com/watch?v=kd3dr39rgrk",
                duration = 900,
                about = "Learn the fundamentals of Python programming, including its history, use cases, and why it is one of the most popular languages in the world today. Set up your Python environment to get started.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/python_intro.png"
            ),
            Video(
                id = 12,
                courseId = 13,
                title = "Mastering Python Data Structures",
                url = "https://www.youtube.com/watch?v=p15xzjzR9j0",
                duration = 1200,
                about = "Dive deep into Python's built-in data structures such as lists, tuples, dictionaries, and sets. Learn how to effectively use them in real-world applications with hands-on examples.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/python_data_structures.png"
            ),
            Video(
                id = 13,
                courseId = 13,
                title = "Working with Files and Modules in Python",
                url = "https://www.youtube.com/watch?v=GxCXiSkm6no",
                duration = 1500,
                about = "Understand how to read, write, and manipulate files in Python. Discover the power of Python modules and how to create and import your own custom modules to streamline your code.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/python_files_modules.png"
            ),
            Video(
                id = 14,
                courseId = 13,
                title = "Introduction to NumPy and Pandas",
                url = "https://www.youtube.com/watch?v=KHoEbRH46Zk",
                duration = 1800,
                about = "Explore the advanced capabilities of Python's NumPy and Pandas libraries. Learn how to manipulate large datasets, perform efficient numerical computations, and prepare data for analysis.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/python_numpy_pandas.png"
            ),
            Video(
                id = 15,
                courseId = 13,
                title = "Building a Data Analysis Project in Python",
                url = "https://www.youtube.com/watch?v=4sZFkPw87ng",
                duration = 2100,
                about = "Apply your knowledge by creating a data analysis project from scratch. Clean and analyze real-world datasets using Python libraries, and visualize your results with libraries like Matplotlib.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/python_project.png"
            ),
            Video(
                id = 21,
                courseId = 14,
                title = "Introduction to Web Development",
                url = "https://www.youtube.com/watch?v=ysEN5RaKOlA",
                duration = 900,
                about = "Learn the basics of web development, including the client-server model, HTTP, and how websites work. Understand the key technologies that power the web.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/web_intro.png"
            ),
            Video(
                id = 22,
                courseId = 14,
                title = "HTML Essentials: Building the Structure",
                url = "https://www.youtube.com/watch?v=salY_Sm6mv4",
                duration = 1200,
                about = "Master the fundamentals of HTML, including tags, attributes, and document structure. Learn how to create a semantic and accessible web page layout.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/html_basics.png"
            ),
            Video(
                id = 23,
                courseId = 14,
                title = "CSS Basics: Styling Your Website",
                url = "https://www.youtube.com/watch?v=ysEN5RaKOlA",
                duration = 1500,
                about = "Learn how to style web pages with CSS. Understand selectors, properties, and layout techniques to create visually appealing designs.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/css_basics.png"
            ),
            Video(
                id = 24,
                courseId = 14,
                title = "JavaScript Fundamentals",
                url = "https://www.youtube.com/watch?v=lkIFF4maKMU",
                duration = 1800,
                about = "Dive into the basics of JavaScript, including variables, functions, loops, and events. Learn how to add interactivity to your web pages.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/javascript_intro.png"
            ),
            Video(
                id = 25,
                courseId = 14,
                title = "Getting Started with React",
                url = "https://www.youtube.com/watch?v=SqcY0GlETPk",
                duration = 2000,
                about = "Discover the basics of React, including components, props, and state. Build dynamic and reusable UI elements with ease.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/react_intro.png"
            ),
            Video(
                id = 26,
                courseId = 14,
                title = "Backend Basics with Node.js",
                url = "https://www.youtube.com/watch?v=ENrzD9HAZK4",
                duration = 2100,
                about = "Learn the fundamentals of Node.js for backend development. Understand how to create a server, handle requests, and work with APIs.",
                order = 6,
                thumbnailUrl = "https://example.com/thumbnails/nodejs_intro.png"
            ),
            Video(
                id = 30,
                courseId = 15,
                title = "Getting Started with Kotlin for Android",
                url = "https://www.youtube.com/watch?v=XLt_moCoauw",
                duration = 1200,
                about = "An introduction to Kotlin programming language, its advantages, and how it integrates seamlessly with Android development. Set up your Android Studio environment for Kotlin.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/kotlin_intro.png"
            ),
            Video(
                id = 31,
                courseId = 15,
                title = "Designing Layouts and UI in Android",
                url = "https://www.youtube.com/watch?v=XLt_moCoauw",
                duration = 1500,
                about = "Learn how to design and implement user interfaces in Android using XML layouts and ViewGroups. Understand how to build responsive and dynamic UIs for different screen sizes.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/android_layouts.png"
            ),
            Video(
                id = 32,
                courseId = 15,
                title = "Connecting to APIs in Kotlin",
                url = "https://www.youtube.com/watch?v=XLt_moCoauw",
                duration = 1800,
                about = "Master the basics of making network requests in Kotlin. Learn how to integrate REST APIs into your Android app using libraries like Retrofit for seamless data fetching and parsing.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/kotlin_apis.png"
            ),
            Video(
                id = 40,
                courseId = 16,
                title = "Introduction to Data Structures and Algorithms",
                url = "https://www.youtube.com/watch?v=oz9cEqFynHU",
                duration = 1200,
                about = "Understand the importance of data structures and algorithms in problem-solving and software development. Learn how to approach computational problems efficiently.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/dsa_intro.png"
            ),
            Video(
                id = 41,
                courseId = 16,
                title = "Mastering Arrays and Pointers in C++",
                url = "https://www.youtube.com/watch?v=IrGjyfBC-u0&t=409s",
                duration = 1500,
                about = "Dive into the fundamentals of arrays and pointers in C++. Learn how to manipulate and manage memory effectively for optimal performance.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/cpp_arrays.png"
            ),
            Video(
                id = 42,
                courseId = 16,
                title = "Linked Lists: Singly, Doubly, and Circular",
                url = "https://www.youtube.com/watch?v=N6dOwBde7-M",
                duration = 1800,
                about = "Learn the implementation and use cases of different types of linked lists. Understand how they work and when to use singly, doubly, or circular linked lists.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/cpp_linked_lists.png"
            ),
            Video(
                id = 43,
                courseId = 16,
                title = "Understanding Stacks and Queues",
                url = "https://www.youtube.com/watch?v=A3ZUpyrnCbM",
                duration = 1600,
                about = "Master the concepts of stacks and queues in C++. Learn how to implement them and explore their applications in solving real-world problems.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/cpp_stacks_queues.png"
            ),
            Video(
                id = 44,
                courseId = 16,
                title = "Trees and Binary Search Trees (BSTs)",
                url = "https://www.youtube.com/watch?v=mtvbVLK5xDQ",
                duration = 2000,
                about = "Explore the fundamentals of trees and binary search trees. Learn how to traverse, search, and manipulate tree structures in C++.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/cpp_trees.png"
            ),
            Video(
                id = 45,
                courseId = 16,
                title = "Graph Algorithms: BFS and DFS",
                url = "https://www.youtube.com/watch?v=pcKY4hjDrxk",
                duration = 2200,
                about = "Understand graph representations and implement Breadth-First Search (BFS) and Depth-First Search (DFS) algorithms. Learn their practical applications in problem-solving.",
                order = 6,
                thumbnailUrl = "https://example.com/thumbnails/cpp_graphs.png"
            ),
            Video(
                id = 46,
                courseId = 16,
                title = "Dynamic Programming Basics",
                url = "https://www.youtube.com/watch?v=aPQY__2H3tE",
                duration = 2400,
                about = "Get introduced to dynamic programming concepts. Learn how to break down complex problems into smaller subproblems and solve them efficiently.",
                order = 7,
                thumbnailUrl = "https://example.com/thumbnails/cpp_dynamic_programming.png"
            ),
            Video(
                id = 47,
                courseId = 16,
                title = "Solving Complex Problems with Dynamic Programming",
                url = "https://www.youtube.com/watch?v=aPQY__2H3tE",
                duration = 2700,
                about = "Apply dynamic programming techniques to solve advanced problems. Work through real-world examples and understand how to optimize your solutions.",
                order = 8,
                thumbnailUrl = "https://example.com/thumbnails/cpp_advanced_dp.png"
            ),
            Video(
                id = 50,
                courseId = 17,
                title = "Introduction to Machine Learning Concepts",
                url = "https://www.youtube.com/watch?v=yN7ypxC7838",
                duration = 1200,
                about = "Get an overview of machine learning, its applications, and types such as supervised, unsupervised, and reinforcement learning. Understand how machine learning fits into the broader field of AI.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/ml_intro.png"
            ),
            Video(
                id = 51,
                courseId = 17,
                title = "Setting Up Python for Machine Learning",
                url = "https://www.youtube.com/watch?v=SnDhxxaBn0A",
                duration = 1100,
                about = "Learn how to set up your Python environment for machine learning projects. Install and configure essential libraries like NumPy, Pandas, Matplotlib, and Scikit-learn.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/ml_python_setup.png"
            ),
            Video(
                id = 52,
                courseId = 17,
                title = "Data Preprocessing and Feature Engineering",
                url = "https://www.youtube.com/watch?v=GduT2ZCc26E",
                duration = 1300,
                about = "Understand how to preprocess raw data for machine learning. Learn techniques like normalization, encoding categorical variables, and feature selection to improve model performance.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/ml_data_preprocessing.png"
            ),
            Video(
                id = 53,
                courseId = 17,
                title = "Supervised Learning: Regression Basics",
                url = "https://www.youtube.com/watch?v=yN7ypxC7838&t=25s",
                duration = 1400,
                about = "Dive into supervised learning with regression algorithms. Understand how linear regression works and apply it to solve real-world prediction problems.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/ml_regression.png"
            ),
            Video(
                id = 54,
                courseId = 17,
                title = "Supervised Learning: Classification Basics",
                url = "https://www.youtube.com/watch?v=TJveOYsK6MY",
                duration = 1250,
                about = "Learn the fundamentals of classification algorithms, including logistic regression and decision trees. Build a model to classify data into distinct categories.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/ml_classification.png"
            ),
            Video(
                id = 55,
                courseId = 17,
                title = "Unsupervised Learning: Clustering Techniques",
                url = "https://www.youtube.com/watch?v=RDZUdRSDOok",
                duration = 1450,
                about = "Explore unsupervised learning methods like K-Means and Hierarchical Clustering. Learn how to group similar data points and uncover hidden patterns.",
                order = 6,
                thumbnailUrl = "https://example.com/thumbnails/ml_clustering.png"
            ),
            Video(
                id = 56,
                courseId = 17,
                title = "Model Evaluation and Cross-Validation",
                url = "https://www.youtube.com/watch?v=fSytzGwwBVw&t=25s",
                duration = 1500,
                about = "Understand how to evaluate machine learning models using metrics like accuracy, precision, recall, and F1-score. Learn about cross-validation techniques to assess model performance.",
                order = 7,
                thumbnailUrl = "https://example.com/thumbnails/ml_evaluation.png"
            ),
            Video(
                id = 57,
                courseId = 17,
                title = "Introduction to Neural Networks",
                url = "https://www.youtube.com/watch?v=aircAruvnKk",
                duration = 1600,
                about = "Get started with neural networks. Understand the architecture of a neural network, including layers, nodes, and activation functions.",
                order = 8,
                thumbnailUrl = "https://example.com/thumbnails/ml_neural_networks.png"
            ),
            Video(
                id = 58,
                courseId = 17,
                title = "Working with Scikit-learn for Machine Learning",
                url = "https://www.youtube.com/watch?v=8j47pwqVc6g",
                duration = 1350,
                about = "Learn how to implement machine learning algorithms in Python using Scikit-learn. Build and train models for both regression and classification problems.",
                order = 9,
                thumbnailUrl = "https://example.com/thumbnails/ml_scikit_learn.png"
            ),
            Video(
                id = 59,
                courseId = 17,
                title = "Building a Machine Learning Project",
                url = "https://www.youtube.com/watch?v=Hr06nSA-qww",
                duration = 1800,
                about = "Apply all the concepts learned by building a complete machine learning project from scratch. Work on data preprocessing, model selection, and result visualization.",
                order = 10,
                thumbnailUrl = "https://example.com/thumbnails/ml_project.png"
            ),
            Video(
                id = 60,
                courseId = 21,
                title = "Introduction to Microeconomics Concepts",
                url = "https://www.youtube.com/watch?v=1UxA6JzoT-4",
                duration = 1200,
                about = "An introduction to microeconomics, covering the key concepts such as scarcity, opportunity cost, and the role of economics in everyday decisions.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/microeconomics_intro.png"
            ),
            Video(
                id = 61,
                courseId = 21,
                title = "Understanding Supply and Demand",
                url = "https://www.youtube.com/watch?v=kIFBaaPJUO0",
                duration = 1300,
                about = "Learn about the fundamental forces of supply and demand. Explore how prices are determined in markets and the factors that influence supply and demand curves.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/supply_demand.png"
            ),
            Video(
                id = 62,
                courseId = 21,
                title = "Market Structures: Perfect Competition vs Monopoly",
                url = "https://www.youtube.com/watch?v=Z9e_7j9WzA0",
                duration = 1400,
                about = "Examine the different types of market structures, such as perfect competition, monopolies, and oligopolies. Understand how they influence pricing and consumer choices.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/market_structures.png"
            ),
            Video(
                id = 63,
                courseId = 21,
                title = "Consumer Behavior and Utility Theory",
                url = "https://www.youtube.com/watch?v=cEdDOzoa8wM",
                duration = 1500,
                about = "Explore how consumers make choices based on their preferences and budget. Learn about utility theory and how it helps in understanding consumer demand.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/consumer_behavior.png"
            ),
            Video(
                id = 65,
                courseId = 22,
                title = "Introduction to Financial Markets",
                url = "https://www.youtube.com/watch?v=UOwi7MBSfhk",
                duration = 1200,
                about = "Understand the basics of financial markets, including the role they play in the global economy. Learn about the different types of financial markets such as stock markets, bond markets, and commodities.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/financial_markets_intro.png"
            ),
            Video(
                id = 66,
                courseId = 22,
                title = "How the Stock Market Works",
                url = "https://www.youtube.com/watch?v=p7HKvqRI_Bo",
                duration = 1300,
                about = "Dive into the stock market, how stocks are traded, and the factors that influence stock prices. Learn about stock exchanges, market orders, and trading strategies.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/stock_market.png"
            ),
            Video(
                id = 67,
                courseId = 22,
                title = "Understanding Bonds and Fixed Income Securities",
                url = "https://www.youtube.com/watch?v=84wl3ilvhfY",
                duration = 1400,
                about = "Learn the fundamentals of bonds and fixed income securities. Explore how they work, their types, and how investors use them for income and risk management.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/bonds_investment.png"
            ),
            Video(
                id = 68,
                courseId = 22,
                title = "Introduction to Derivatives: Futures and Options",
                url = "https://www.youtube.com/watch?v=nf9ByTdX0aY",
                duration = 1500,
                about = "Understand the basics of derivative instruments like futures and options. Learn how they are used for hedging, speculation, and risk management in financial markets.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/derivatives.png"
            ),
            Video(
                id = 69,
                courseId = 22,
                title = "Investment Strategies: Value vs Growth",
                url = "https://www.youtube.com/watch?v=6sUvcWpPvFE",
                duration = 1600,
                about = "Explore the two major investment strategies: value investing and growth investing. Understand how each strategy works and how to apply them to your investment portfolio.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/investment_strategies.png"
            ),
            Video(
                id = 70,
                courseId = 22,
                title = "Technical Analysis: Chart Patterns and Indicators",
                url = "https://www.youtube.com/watch?v=eynxyoKgpng",
                duration = 1700,
                about = "Learn the basics of technical analysis, including chart patterns, trendlines, and technical indicators. Discover how these tools are used to make trading decisions in the financial markets.",
                order = 6,
                thumbnailUrl = "https://example.com/thumbnails/technical_analysis.png"
            ),
            Video(
                id = 74,
                courseId = 23,
                title = "Introduction to Macroeconomics and GDP",
                url = "https://www.youtube.com/watch?v=BnrBRuoVefY",
                duration = 1300,
                about = "Explore the basics of macroeconomics and understand the concept of Gross Domestic Product (GDP) as a measure of a country's economic performance.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/macroeconomics_intro.png"
            ),
            Video(
                id = 75,
                courseId = 23,
                title = "Inflation and Its Impact on the Economy",
                url = "https://www.youtube.com/watch?v=zIbNJCSCEjk",
                duration = 1400,
                about = "Learn about inflation, how it is measured, and its effects on purchasing power, wages, and interest rates in an economy.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/inflation.png"
            ),
            Video(
                id = 76,
                courseId = 23,
                title = "Unemployment and Economic Cycles",
                url = "https://www.youtube.com/watch?v=Y5jr_zv2Y9M&t=57s",
                duration = 1500,
                about = "Understand the causes and types of unemployment, and learn how unemployment rates affect the overall economy and business cycles.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/unemployment.png"
            ),
            Video(
                id = 77,
                courseId = 23,
                title = "Fiscal Policy and Government Intervention",
                url = "https://www.youtube.com/watch?v=eE_FYK2FlnQ",
                duration = 1600,
                about = "Explore fiscal policy, government spending, taxation, and their roles in managing economic stability and growth.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/fiscal_policy.png"
            ),
            Video(
                id = 78,
                courseId = 24,
                title = "Introduction to Investing and Portfolio Basics",
                url = "https://www.youtube.com/watch?v=8Ij7A1VCB7I",
                duration = 1200,
                about = "Learn the basics of investing, including asset allocation and the importance of diversification in building a balanced portfolio.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/investing_intro.png"
            ),
            Video(
                id = 79,
                courseId = 24,
                title = "Risk Management and Investment Strategies",
                url = "https://www.youtube.com/watch?v=H98T8KASxT4",
                duration = 1300,
                about = "Understand how to assess investment risks and use strategies to mitigate them. Learn about risk tolerance and setting investment goals.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/risk_management.png"
            ),
            Video(
                id = 80,
                courseId = 24,
                title = "The Power of Compound Interest in Wealth Building",
                url = "https://www.youtube.com/watch?v=jJhkoX_b4-8",
                duration = 1400,
                about = "Discover the power of compound interest and how it can accelerate the growth of your investments over time.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/compound_interest.png"
            ),
            Video(
                id = 81,
                courseId = 24,
                title = "Introduction to Stocks and Bonds",
                url = "https://www.youtube.com/watch?v=qIw-yFC-HNU",
                duration = 1500,
                about = "Learn the basics of stocks and bonds, the differences between them, and how they can be used in investment strategies.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/stocks_bonds.png"
            ),
            Video(
                id = 82,
                courseId = 51,
                title = "Understanding Macronutrients: Proteins, Carbs, and Fats",
                url = "https://www.youtube.com/watch?v=1KvJBolzEDc",
                duration = 1300,
                about = "Learn about macronutrients, their role in the body, and how to balance proteins, carbohydrates, and fats in a healthy diet.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/micronutrients.png"
            ),
            Video(
                id = 83,
                courseId = 51,
                title = "Essential Vitamins and Minerals for Health",
                url = "https://www.youtube.com/watch?v=Tl13Z42277s",
                duration = 1400,
                about = "Explore the importance of vitamins and minerals, their benefits, and the best food sources to meet your daily nutritional needs.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/vitamins_minerals.png"
            ),
            Video(
                id = 84,
                courseId = 51,
                title = "Building Healthy Eating Habits",
                url = "https://www.youtube.com/watch?v=Q4yUlJV31Rk",
                duration = 1500,
                about = "Learn how to develop healthy eating habits, plan balanced meals, and maintain a sustainable diet for long-term health.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/healthy_eating.png"
            ),
            Video(
                id = 85,
                courseId = 51,
                title = "Understanding Food Labels and Nutritional Facts",
                url = "https://www.youtube.com/watch?v=Tl13Z42277s",
                duration = 1600,
                about = "Learn how to read food labels and understand the nutritional facts to make informed choices about the food you eat.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/food_labels.png"
            ),
            Video(
                id = 86,
                courseId = 52,
                title = "Introduction to Yoga: Basic Poses and Breathing Techniques",
                url = "https://www.youtube.com/watch?v=149Iac5fmoE",
                duration = 1200,
                about = "Get an introduction to yoga, focusing on basic poses and breathing techniques that help improve flexibility and reduce stress.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/yoga_intro.png"
            ),
            Video(
                id = 87,
                courseId = 52,
                title = "The Importance of Flexibility in Yoga Practice",
                url = "https://www.youtube.com/watch?v=149Iac5fmoE",
                duration = 1300,
                about = "Understand how flexibility plays a key role in yoga and learn how to improve your flexibility over time through regular practice.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/flexibility_in_yoga.png"
            ),
            Video(
                id = 88,
                courseId = 52,
                title = "Breathing Techniques for Stress Relief",
                url = "https://www.youtube.com/watch?v=odADwWzHR24",
                duration = 1400,
                about = "Learn the different breathing techniques in yoga that help manage stress and promote relaxation and mindfulness.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/yoga_breathing.png"
            ),
            Video(
                id = 89,
                courseId = 52,
                title = "Yoga for Mindfulness and Mental Well-being",
                url = "https://www.youtube.com/watch?v=bLpChrgS0AY",
                duration = 1500,
                about = "Explore the benefits of yoga for mental health, mindfulness, and improving overall well-being through regular practice.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/yoga_mental_wellbeing.png"
            ),
            Video(
                id = 90,
                courseId = 53,
                title = "Introduction to Mental Health Concepts",
                url = "https://www.youtube.com/watch?v=oxx564hMBUI",
                duration = 1300,
                about = "Understand the basic concepts of mental health, including common mental health disorders such as depression, anxiety, and stress.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/mental_health_intro.png"
            ),
            Video(
                id = 91,
                courseId = 53,
                title = "Managing Stress and Anxiety",
                url = "https://www.youtube.com/watch?v=ntfcfJ28eiU",
                duration = 1400,
                about = "Learn effective strategies for managing stress and anxiety, including relaxation techniques, time management, and seeking support.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/stress_management.png"
            ),
            Video(
                id = 92,
                courseId = 53,
                title = "Mental Health and Well-being: A Holistic Approach",
                url = "https://www.youtube.com/watch?v=oxx564hMBUI",
                duration = 1500,
                about = "Explore how physical health, sleep, nutrition, and mindfulness contribute to mental well-being and strategies for maintaining a balanced life.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/mental_health_wellbeing.png"
            ),
            Video(
                id = 93,
                courseId = 54,
                title = "Full Body Home Workout Routine",
                url = "https://www.youtube.com/watch?v=cbKkB3POqaY",
                duration = 1200,
                about = "Learn a full-body workout routine that can be done at home with no equipment, targeting all major muscle groups.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/full_body_home_workout.png"
            ),
            Video(
                id = 94,
                courseId = 54,
                title = "Core Strengthening Exercises for Beginners",
                url = "https://www.youtube.com/watch?v=3XVGDYuPay4",
                duration = 1300,
                about = "Focus on building core strength with simple, effective exercises that can be performed at home without equipment.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/core_strengthening.png"
            ),
            Video(
                id = 95,
                courseId = 54,
                title = "Upper Body Strengthening Exercises",
                url = "https://www.youtube.com/watch?v=cbKkB3POqaY",
                duration = 1400,
                about = "Strengthen your arms, shoulders, and chest with upper-body exercises that you can do at home with minimal equipment.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/upper_body_workout.png"
            ),
            Video(
                id = 96,
                courseId = 55,
                title = "Basics of Meditation and Mindfulness",
                url = "https://www.youtube.com/watch?v=thcEuMDWxoI",
                duration = 1200,
                about = "Learn the basics of meditation and mindfulness, including different meditation techniques and how to incorporate them into your daily life.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/meditation_basics.png"
            ),
            Video(
                id = 97,
                courseId = 55,
                title = "Mindfulness Meditation for Stress Relief",
                url = "https://www.youtube.com/watch?v=z6X5oEIg6Ak",
                duration = 1300,
                about = "Practice mindfulness meditation to reduce stress and promote relaxation, with easy-to-follow guided exercises.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/mindfulness_meditation.png"
            ),
            Video(
                id = 98,
                courseId = 55,
                title = "Deep Breathing Techniques for Meditation",
                url = "https://www.youtube.com/watch?v=z6X5oEIg6Ak",
                duration = 1400,
                about = "Explore deep breathing techniques to enhance your meditation practice and help manage stress, anxiety, and sleep issues.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/deep_breathing_techniques.png"
            ),
            Video(
                id = 100,
                courseId = 56,
                title = "High-Intensity Interval Training (HIIT) for Weight Loss",
                url = "https://www.youtube.com/watch?v=XGtjACeyHtc",
                duration = 1200,
                about = "Learn the basics of High-Intensity Interval Training (HIIT) to burn fat effectively and improve cardiovascular health.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/hiit_cardio.png"
            ),
            Video(
                id = 101,
                courseId = 56,
                title = "Running and Jogging for Weight Loss",
                url = "https://www.youtube.com/watch?v=-FAEPOaYsB0",
                duration = 1300,
                about = "Explore running and jogging techniques that can help you burn calories and lose weight, tailored for beginners and intermediate levels.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/running_for_weight_loss.png"
            ),
            Video(
                id = 102,
                courseId = 56,
                title = "Jump Rope: A Full-Body Cardio Workout",
                url = "https://www.youtube.com/watch?v=XGtjACeyHtc",
                duration = 1100,
                about = "A fun and effective cardio workout using a jump rope to burn calories and improve endurance.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/jump_rope_cardio.png"
            ),
            Video(
                id = 103,
                courseId = 57,
                title = "Introduction to the Human Body",
                url = "https://www.youtube.com/watch?v=uBGl2BujkPQ",
                duration = 1500,
                about = "An overview of the human body, exploring the structure and functions of organs and body systems.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/human_body_intro.png"
            ),
            Video(
                id = 104,
                courseId = 57,
                title = "The Skeletal System: Structure and Function",
                url = "https://www.youtube.com/watch?v=RNLceVI8jcc",
                duration = 1400,
                about = "Learn about the human skeletal system, its components, and how bones provide support and protection for the body.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/skeletal_system.png"
            ),
            Video(
                id = 105,
                courseId = 57,
                title = "The Nervous System and Brain",
                url = "https://www.youtube.com/watch?v=RNLceVI8jcc",
                duration = 1600,
                about = "Explore the brain and nervous system, and how they control and coordinate the functions of the body.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/nervous_system_brain.png"
            ),
            Video(
                id = 106,
                courseId = 58,
                title = "Simple and Healthy Breakfast Ideas",
                url = "https://www.youtube.com/watch?v=EyFcGkeL_kA",
                duration = 1300,
                about = "Learn how to prepare nutritious and easy-to-make breakfast meals to start your day off right.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/healthy_breakfast.png"
            ),
            Video(
                id = 107,
                courseId = 58,
                title = "Healthy Lunch Recipes for Busy Days",
                url = "https://www.youtube.com/watch?v=uBGl2BujkPQ",
                duration = 1400,
                about = "Discover quick and healthy lunch recipes that can be prepared in 30 minutes or less, perfect for a busy lifestyle.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/healthy_lunch_recipes.png"
            ),
            Video(
                id = 108,
                courseId = 58,
                title = "Nutritious and Delicious Dinner Recipes",
                url = "https://www.youtube.com/watch?v=AYXfaVD5o40",
                duration = 1500,
                about = "Explore dinner recipes that are both nutritious and satisfying, designed to keep you healthy while enjoying great food.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/healthy_dinner.png"
            ),
            Video(
                id = 109,
                courseId = 59,
                title = "Basic First Aid Skills",
                url = "https://www.youtube.com/watch?v=T_S_fM7l84Q",
                duration = 1200,
                about = "Learn essential first aid skills including CPR, wound care, and how to respond to common medical emergencies.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/basic_first_aid.png"
            ),
            Video(
                id = 110,
                courseId = 59,
                title = "Handling Medical Emergencies: A First Responder's Guide",
                url = "https://www.youtube.com/watch?v=4CeXKcWtohw",
                duration = 1300,
                about = "Gain knowledge of how to handle medical emergencies such as heart attacks, choking, and fractures until professional help arrives.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/medical_emergencies.png"
            ),
            Video(
                id = 111,
                courseId = 59,
                title = "How to Perform CPR and Use an AED",
                url = "https://www.youtube.com/watch?v=2VxVQ2expR0",
                duration = 1400,
                about = "Learn the life-saving techniques of performing CPR and using an Automated External Defibrillator (AED) in an emergency.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/cpr_aed.png"
            ),
            Video(
                id = 112,
                courseId = 60,
                title = "Breathing Exercises for Stress Relief",
                url = "https://www.youtube.com/watch?v=LiUnFJ8P4gM",
                duration = 1100,
                about = "Learn simple breathing techniques to reduce stress, improve focus, and enhance relaxation.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/breathing_exercises.png"
            ),
            Video(
                id = 113,
                courseId = 60,
                title = "Mindfulness Meditation for Stress Reduction",
                url = "https://www.youtube.com/watch?v=LiUnFJ8P4gM",
                duration = 1200,
                about = "Practice mindfulness meditation to help reduce stress and enhance overall well-being.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/mindfulness_stress_reduction.png"
            ),
            Video(
                id = 114,
                courseId = 60,
                title = "Yoga and Stretching for Stress Relief",
                url = "https://www.youtube.com/watch?v=yqeirBfn2j4",
                duration = 1300,
                about = "Discover yoga poses and stretching exercises that can help alleviate stress and improve mental clarity.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/yoga_for_stress_relief.png"
            ),
            Video(
                id = 115,
                courseId = 80,
                title = "Introduction to Time Management",
                url = "https://www.youtube.com/watch?v=fWRF6BJ1OQk",
                duration = 1000,
                about = "Learn the basics of time management, including how to prioritize tasks and set effective goals to boost your productivity.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/time_management_intro.png"
            ),
            Video(
                id = 116,
                courseId = 80,
                title = "Techniques for Prioritizing Tasks",
                url = "https://www.youtube.com/watch?v=czh4rmk75jc",
                duration = 1200,
                about = "Master time management techniques like the Eisenhower matrix and the Pomodoro method to prioritize your daily tasks.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/task_prioritization.png"
            ),
            Video(
                id = 117,
                courseId = 80,
                title = "Overcoming Procrastination",
                url = "https://www.youtube.com/watch?v=fWRF6BJ1OQk",
                duration = 1100,
                about = "Learn effective strategies to stop procrastinating and get your work done on time.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/overcoming_procrastination.png"
            ),
            Video(
                id = 118,
                courseId = 80,
                title = "Goal Setting and Time Blocking",
                url = "https://www.youtube.com/watch?v=fWRF6BJ1OQk",
                duration = 1300,
                about = "Understand how to set realistic goals and use time-blocking techniques to allocate time to each task efficiently.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/goal_setting_time_blocking.png"
            ),
            Video(
                id = 119,
                courseId = 81,
                title = "Overcoming the Fear of Public Speaking",
                url = "https://www.youtube.com/watch?v=aImrjNPrh30",
                duration = 1100,
                about = "Learn techniques to overcome your fear of public speaking and gain confidence in front of an audience.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/fear_of_public_speaking.png"
            ),
            Video(
                id = 120,
                courseId = 81,
                title = "Speech Delivery Techniques",
                url = "https://www.youtube.com/watch?v=aImrjNPrh30",
                duration = 1200,
                about = "Discover proven methods to deliver your speech with confidence and clarity, including voice modulation and body language tips.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/speech_delivery.png"
            ),
            Video(
                id = 121,
                courseId = 81,
                title = "Building Rapport with Your Audience",
                url = "https://www.youtube.com/watch?v=S6ODnwgIcXs",
                duration = 1100,
                about = "Learn how to connect with your audience emotionally and maintain engagement throughout your presentation.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/building_rapport.png"
            ),
            Video(
                id = 122,
                courseId = 82,
                title = "Understanding Emotional Intelligence",
                url = "https://www.youtube.com/watch?v=D6_J7FfgWVc",
                duration = 1000,
                about = "Learn what emotional intelligence is, and how it can impact your personal and professional relationships.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/emotional_intelligence_intro.png"
            ),
            Video(
                id = 123,
                courseId = 82,
                title = "Self-Awareness and Self-Regulation",
                url = "https://www.youtube.com/watch?v=tGdsOXZpyWE",
                duration = 1200,
                about = "Understand the importance of self-awareness and self-regulation in emotional intelligence and how they influence your actions.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/self_awareness.png"
            ),
            Video(
                id = 124,
                courseId = 82,
                title = "Empathy and Social Skills",
                url = "https://www.youtube.com/watch?v=D6_J7FfgWVc",
                duration = 1300,
                about = "Discover how to enhance empathy and social skills to build stronger, more positive relationships with others.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/empathy_social_skills.png"
            ),
            Video(
                id = 125,
                courseId = 83,
                title = "Understanding the Importance of Self-Discipline",
                url = "https://www.youtube.com/watch?v=Ky7ARprxpNM",
                duration = 1100,
                about = "Learn why self-discipline is key to achieving your personal and professional goals and how to cultivate it.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/self_discipline_intro.png"
            ),
            Video(
                id = 126,
                courseId = 83,
                title = "Building Habits for Long-Term Success",
                url = "https://www.youtube.com/watch?v=Wcs2PFz5q6g&t=5306s",
                duration = 1200,
                about = "Understand how to build lasting habits and routines that promote self-discipline and personal growth.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/long_term_success.png"
            ),
            Video(
                id = 127,
                courseId = 83,
                title = "Staying Motivated During Difficult Times",
                url = "https://www.youtube.com/watch?v=y_hi8gX9WuA",
                duration = 1300,
                about = "Learn how to stay motivated and focused on your goals, even during challenging situations.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/motivation_during_challenge.png"
            ),
            Video(
                id = 130,
                courseId = 84,
                title = "Introduction to Mindfulness",
                url = "https://www.youtube.com/watch?v=qkA5SpvQsJA",
                duration = 1000,
                about = "Learn the basics of mindfulness, its benefits, and how to incorporate mindfulness practices into daily life.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/mindfulness_intro.png"
            ),
            Video(
                id = 131,
                courseId = 84,
                title = "Mindful Breathing Techniques",
                url = "https://www.youtube.com/watch?v=2Bbn18q6Ut0",
                duration = 1100,
                about = "Master breathing exercises to help reduce stress, enhance focus, and increase mindfulness in everyday activities.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/mindful_breathing.png"
            ),
            Video(
                id = 132,
                courseId = 84,
                title = "Practicing Mindfulness in Daily Activities",
                url = "https://www.youtube.com/watch?v=jzcwBEvDEYg",
                duration = 1200,
                about = "Learn how to apply mindfulness during common activities like eating, walking, and interacting with others.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/mindfulness_daily.png"
            ),
            Video(
                id = 133,
                courseId = 101,
                title = "Introduction to Guitar Basics",
                url = "https://www.youtube.com/watch?v=BBz-Jyr23M4",
                duration = 1000,
                about = "Get familiar with the parts of a guitar, how to hold it, and tune it, before diving into the first chords.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/guitar_intro.png"
            ),
            Video(
                id = 134,
                courseId = 101,
                title = "Learning Your First Chords",
                url = "https://www.youtube.com/watch?v=cUxRhesT8gY",
                duration = 1200,
                about = "Learn to play your first basic guitar chords and practice transitioning between them.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/guitar_chords.png"
            ),
            Video(
                id = 135,
                courseId = 101,
                title = "Strumming Techniques",
                url = "https://www.youtube.com/watch?v=yT8hHdbiMOU",
                duration = 1100,
                about = "Learn basic strumming patterns to accompany your chords and improve your rhythm skills.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/guitar_strumming.png"
            ),
            Video(
                id = 136,
                courseId = 102,
                title = "Introduction to Music Theory",
                url = "https://www.youtube.com/watch?v=cUxRhesT8gY",
                duration = 1100,
                about = "Learn the fundamental concepts of music theory including scales, notes, and intervals.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/music_theory_intro.png"
            ),
            Video(
                id = 137,
                courseId = 102,
                title = "Understanding Scales and Harmony",
                url = "https://www.youtube.com/watch?v=oU4i59Mf8Yo",
                duration = 1200,
                about = "Dive into the basics of scales and how they form the foundation for harmony in music.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/scales_harmony.png"
            ),
            Video(
                id = 138,
                courseId = 102,
                title = "The Role of Rhythm in Music",
                url = "https://www.youtube.com/watch?v=F21pS3Wo8ko",
                duration = 1300,
                about = "Understand how rhythm plays a crucial role in shaping music and how to apply it effectively.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/rhythm_music.png"
            ),
            Video(
                id = 140,
                courseId = 103,
                title = "Breathing Techniques for Singers",
                url = "https://www.youtube.com/watch?v=yT8hHdbiMOU",
                duration = 1000,
                about = "Learn essential breathing techniques that will help improve your vocal control and stamina.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/vocal_breathing.png"
            ),
            Video(
                id = 141,
                courseId = 103,
                title = "Pitch Control and Vocal Warm-ups",
                url = "https://www.youtube.com/watch?v=sW0kDEtH53I",
                duration = 1100,
                about = "Practice vocal warm-up exercises and techniques to improve pitch accuracy and voice clarity.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/vocal_warmup.png"
            ),
            Video(
                id = 142,
                courseId = 103,
                title = "Vocal Range Expansion",
                url = "https://www.youtube.com/watch?v=F21pS3Wo8ko",
                duration = 1200,
                about = "Learn how to gradually expand your vocal range safely and effectively.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/vocal_range.png"
            ),
            Video(
                id = 143,
                courseId = 104,
                title = "Setting Up Your First Home Studio",
                url = "https://www.youtube.com/watch?v=PWjfYvf0fsw",
                duration = 1000,
                about = "Learn how to set up a basic home recording studio with the right equipment for music production.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/home_studio_setup.png"
            ),
            Video(
                id = 144,
                courseId = 104,
                title = "Basic Recording Techniques",
                url = "https://www.youtube.com/watch?v=em4b9eq54mE",
                duration = 1100,
                about = "Understand the fundamentals of recording audio, including microphone placement and signal routing.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/recording_techniques.png"
            ),
            Video(
                id = 145,
                courseId = 104,
                title = "Intro to Mixing and Editing",
                url = "https://www.youtube.com/watch?v=Hi72cCOPUQU",
                duration = 1200,
                about = "Learn the basics of mixing, editing, and processing your tracks using professional software.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/mixing_editing.png"
            ),
            Video(
                id = 146,
                courseId = 120,
                title = "Basic Drawing Tools and Techniques",
                url = "https://www.youtube.com/watch?v=Pjru1PJ82io",
                duration = 1000,
                about = "Learn about the essential tools for drawing and basic techniques like shading and sketching.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/drawing_tools.png"
            ),
            Video(
                id = 147,
                courseId = 120,
                title = "Understanding Proportions and Perspective",
                url = "https://www.youtube.com/watch?v=lCaf9RHEfpc",
                duration = 1100,
                about = "Learn how to draw with correct proportions and perspective to create realistic images.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/proportions_perspective.png"
            ),
            Video(
                id = 148,
                courseId = 120,
                title = "Drawing Techniques for Beginners",
                url = "https://www.youtube.com/watch?v=lCaf9RHEfpc",
                duration = 1200,
                about = "Master the basic drawing techniques for creating depth and texture in your sketches.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/drawing_techniques.png"
            ),
            Video(
                id = 150,
                courseId = 121,
                title = "Getting Started with Digital Painting",
                url = "https://www.youtube.com/watch?v=SE2wDkaFIOg",
                duration = 1200,
                about = "Learn the basics of digital painting tools and how to set up your canvas for creative work.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/digital_painting_basics.png"
            ),
            Video(
                id = 151,
                courseId = 121,
                title = "Brush Techniques and Tool Setup",
                url = "https://www.youtube.com/watch?v=SE2wDkaFIOg",
                duration = 1300,
                about = "Master different brush techniques and learn how to set up your digital tools effectively.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/brush_techniques.png"
            ),
            Video(
                id = 152,
                courseId = 122,
                title = "Watercolor Brush Strokes and Blending",
                url = "https://www.youtube.com/watch?v=qGgQrxxnrEo",
                duration = 1100,
                about = "Learn essential watercolor brush strokes and blending techniques to create beautiful artwork.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/watercolor_blending.png"
            ),
            Video(
                id = 153,
                courseId = 122,
                title = "Layering and Creating Depth in Watercolor",
                url = "https://www.youtube.com/watch?v=qGgQrxxnrEo",
                duration = 1200,
                about = "Discover the techniques for layering watercolors to create depth and texture in your paintings.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/watercolor_layering.png"
            ),
            Video(
                id = 154,
                courseId = 130,
                title = "Budgeting for Your Trip",
                url = "https://www.youtube.com/watch?v=DS3qVi8p_e4",
                duration = 1000,
                about = "Learn how to create a travel budget, including tips for saving and managing your expenses.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/travel_budget.png"
            ),
            Video(
                id = 155,
                courseId = 130,
                title = "Creating Your Travel Itinerary",
                url = "https://www.youtube.com/watch?v=psCXOowY6ns",
                duration = 1100,
                about = "Master the art of creating a detailed itinerary that includes must-see attractions and activities.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/travel_itinerary.png"
            ),
            Video(
                id = 160,
                courseId = 132,
                title = "Planning a Safe Solo Trip",
                url = "https://www.youtube.com/watch?v=DS3qVi8p_e4",
                duration = 1100,
                about = "Learn essential tips for planning a safe solo trip, including booking accommodations and handling emergencies.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/solo_trip_planning.png"
            ),
            Video(
                id = 161,
                courseId = 132,
                title = "Solo Travel Safety Tips",
                url = "https://www.youtube.com/watch?v=psCXOowY6ns",
                duration = 1200,
                about = "Discover crucial safety tips for solo travelers, from staying connected to securing your belongings.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/solo_travel_safety.png"
            ),
            Video(
                id = 162,
                courseId = 133,
                title = "Capturing Stunning Travel Photos",
                url = "https://www.youtube.com/watch?v=9sF4hG0vJyQ",
                duration = 1300,
                about = "Learn the best techniques for capturing breathtaking travel photos, from composition to lighting.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/travel_photography_tips.png"
            ),
            Video(
                id = 163,
                courseId = 133,
                title = "Editing Your Travel Photos",
                url = "https://www.youtube.com/watch?v=9sF4hG0vJyQ",
                duration = 1400,
                about = "Master photo editing techniques to enhance your travel photos and make them stand out.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/photo_editing_travel.png"
            ),
            Video(
                id = 165,
                courseId = 134,
                title = "Introduction to Sustainable Tourism",
                url = "https://www.youtube.com/watch?v=oL-X2iQi864",
                duration = 1150,
                about = "Learn the basics of sustainable tourism, its importance, and the environmental impacts of tourism.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/sustainable_tourism_intro.png"
            ),
            Video(
                id = 166,
                courseId = 134,
                title = "Eco-friendly Travel Tips",
                url = "https://www.youtube.com/watch?v=unfc6iVARWA",
                duration = 1200,
                about = "Discover practical tips for reducing your environmental footprint while traveling.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/eco_travel_tips.png"
            ),
            Video(
                id = 167,
                courseId = 150,
                title = "Football Basics: Rules and Techniques",
                url = "https://www.youtube.com/watch?v=dFLaabgXhpc",
                duration = 1300,
                about = "Learn the fundamental rules of football (soccer) and basic techniques for beginners.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/football_basics.png"
            ),
            Video(
                id = 168,
                courseId = 150,
                title = "Understanding Football Strategies",
                url = "https://www.youtube.com/watch?v=Phnt5QZ7X7o",
                duration = 1400,
                about = "Explore basic strategies and formations in football to improve your game understanding.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/football_strategies.png"
            ),
            Video(
                id = 170,
                courseId = 151,
                title = "Basketball Dribbling Techniques",
                url = "https://www.youtube.com/watch?v=oADaM2L1YLc",
                duration = 1100,
                about = "Learn essential dribbling skills to control the ball and maneuver around defenders.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/basketball_dribbling.png"
            ),
            Video(
                id = 171,
                courseId = 151,
                title = "Shooting Fundamentals for Accuracy",
                url = "https://www.youtube.com/watch?v=fHr9kt2VwY4",
                duration = 1200,
                about = "Master the fundamentals of shooting to improve accuracy and consistency on the court.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/basketball_shooting.png"
            ),
            Video(
                id = 172,
                courseId = 151,
                title = "Basketball Team Strategies",
                url = "https://www.youtube.com/watch?v=oADaM2L1YLc",
                duration = 1300,
                about = "Learn basic team strategies and how to work effectively with teammates during games.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/basketball_team.png"
            ),
            Video(
                id = 173,
                courseId = 151,
                title = "Defensive Skills in Basketball",
                url = "https://www.youtube.com/watch?v=oADaM2L1YLc",
                duration = 1250,
                about = "Improve your defensive skills to stop opponents and contribute to your team's success.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/basketball_defense.png"
            ),
            Video(
                id = 174,
                courseId = 152,
                title = "Yoga for Flexibility",
                url = "https://www.youtube.com/watch?v=ScxPABG7QJk",
                duration = 1150,
                about = "Practice yoga poses that enhance flexibility and help prevent injuries for athletes.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/yoga_flexibility.png"
            ),
            Video(
                id = 175,
                courseId = 152,
                title = "Strengthening Yoga Poses",
                url = "https://www.youtube.com/watch?v=0h7taISrO7c",
                duration = 1200,
                about = "Focus on yoga poses that build strength and endurance, essential for athletic performance.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/yoga_strengthening.png"
            ),
            Video(
                id = 176,
                courseId = 152,
                title = "Yoga for Balance and Coordination",
                url = "https://www.youtube.com/watch?v=ScxPABG7QJk",
                duration = 1300,
                about = "Improve balance and coordination through yoga, enhancing overall athletic performance.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/yoga_balance.png"
            ),
            Video(
                id = 177,
                courseId = 152,
                title = "Breathing Techniques for Athletes",
                url = "https://www.youtube.com/watch?v=tybOi4hjZFQ",
                duration = 1100,
                about = "Learn breathing exercises that help increase oxygen flow and improve athletic endurance.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/yoga_breathing.png"
            ),
            Video(
                id = 180,
                courseId = 152,
                title = "Yoga Poses for Flexibility",
                url = "https://www.youtube.com/watch?v=ScxPABG7QJk",
                duration = 1100,
                about = "Learn yoga poses that increase flexibility, helping to prevent injuries and improve mobility.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/yoga_flexibility.png"
            ),
            Video(
                id = 181,
                courseId = 152,
                title = "Building Strength with Yoga",
                url = "https://www.youtube.com/watch?v=ScxPABG7QJk",
                duration = 1200,
                about = "Explore yoga poses that focus on building strength, ideal for athletes looking to enhance their performance.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/yoga_strength.png"
            ),
            Video(
                id = 182,
                courseId = 152,
                title = "Improving Balance and Stability",
                url = "https://www.youtube.com/watch?v=tybOi4hjZFQ",
                duration = 1300,
                about = "Practice yoga poses that improve balance and stability, crucial for athletic performance.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/yoga_balance.png"
            ),
            Video(
                id = 183,
                courseId = 153,
                title = "Proper Running Form",
                url = "https://www.youtube.com/watch?v=brFHyOtTwH4",
                duration = 1000,
                about = "Learn the fundamentals of proper running form to reduce injury risk and improve efficiency.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/running_form.png"
            ),
            Video(
                id = 184,
                courseId = 153,
                title = "Warm-up Exercises for Runners",
                url = "https://www.youtube.com/watch?v=AiohKZonPbo",
                duration = 1100,
                about = "Discover essential warm-up exercises that help prepare your body for running and enhance performance.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/running_warmup.png"
            ),
            Video(
                id = 185,
                courseId = 153,
                title = "Techniques for Building Endurance",
                url = "https://www.youtube.com/watch?v=6Fr3LlLe0V8",
                duration = 1200,
                about = "Learn techniques to build endurance and stamina to sustain longer running sessions.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/running_endurance.png"
            ),
            Video(
                id = 190,
                courseId = 200,
                title = "Active Recall: Study Smarter",
                url = "https://www.youtube.com/watch?v=mzexJPoXBCM",
                duration = 900,
                about = "Learn how to use active recall as a study method to improve memory retention and recall during exams.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/active_recall.png"
            ),
            Video(
                id = 191,
                courseId = 200,
                title = "Spaced Repetition: Maximizing Retention",
                url = "https://www.youtube.com/watch?v=brFHyOtTwH4",
                duration = 1000,
                about = "Discover the benefits of spaced repetition and how to effectively use it for long-term retention.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/spaced_repetition.png"
            ),
            Video(
                id = 192,
                courseId = 201,
                title = "Prioritizing Tasks for Success",
                url = "https://www.youtube.com/watch?v=PPvxtFOqx2w",
                duration = 850,
                about = "Learn how to prioritize tasks effectively to manage your time and energy for academic success.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/prioritizing_tasks.png"
            ),
            Video(
                id = 193,
                courseId = 201,
                title = "Using Time Blocks for Maximum Focus",
                url = "https://www.youtube.com/watch?v=5HINgMMTzPE",
                duration = 950,
                about = "Explore time-blocking techniques to boost your focus and accomplish more in less time.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/time_blocks.png"
            ),
            Video(
                id = 195,
                courseId = 202,
                title = "Analyzing Arguments: A Critical Thinking Approach",
                url = "https://www.youtube.com/watch?v=pP8dWURrEF0&t=274s",
                duration = 950,
                about = "Learn how to identify and evaluate arguments critically in order to make better decisions.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/critical_thinking.png"
            ),
            Video(
                id = 196,
                courseId = 203,
                title = "Fun Memory Games for Kids",
                url = "https://www.youtube.com/watch?v=jwPpxSFQNvw",
                duration = 880,
                about = "Explore interactive and fun memory games that help kids retain new information effectively.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/memory_games.png"
            ),
            Video(
                id = 198,
                courseId = 204,
                title = "Overcoming Stage Fright",
                url = "https://www.youtube.com/watch?v=pP8dWURrEF0&t=274s",
                duration = 1200,
                about = "Learn effective strategies to overcome stage fright and gain confidence when speaking in front of others.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/overcoming_stage_fright.png"
            ),
            Video(
                id = 199,
                courseId = 204,
                title = "Crafting Powerful Presentations",
                url = "https://www.youtube.com/watch?v=yoD8RMq2OkU",
                duration = 1100,
                about = "Master the art of structuring and delivering impactful presentations to captivate your audience.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/powerful_presentations.png"
            ),
            Video(
                id = 200,
                courseId = 205,
                title = "Navigating Virtual Classrooms",
                url = "https://www.youtube.com/watch?v=Twsja-rs0Js",
                duration = 1000,
                about = "Get to know the essential features of online learning platforms and how to navigate them effectively.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/navigating_virtual_classrooms.png"
            ),
            Video(
                id = 201,
                courseId = 205,
                title = "Maximizing Online Study Time",
                url = "https://www.youtube.com/watch?v=jwPpxSFQNvw",
                duration = 950,
                about = "Learn tips and techniques to stay focused and productive while studying in an online environment.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/maximizing_study_time.png"
            ),
            Video(
                id = 202,
                courseId = 206,
                title = "Solving Algebraic Equations",
                url = "https://www.youtube.com/watch?v=Z-ZkmpQBIFo",
                duration = 1200,
                about = "Learn how to solve algebraic equations step by step and apply them to real-world problems.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/algebraic_equations.png"
            ),
            Video(
                id = 203,
                courseId = 206,
                title = "Introduction to Calculus Concepts",
                url = "https://www.youtube.com/watch?v=Kss13U-hvPk",
                duration = 1300,
                about = "Get an overview of key calculus concepts, including limits, derivatives, and integrals.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/calculus_concepts.png"
            ),
            Video(
                id = 204,
                courseId = 207,
                title = "The Rise of Ancient Civilizations",
                url = "https://www.youtube.com/watch?v=ha1NneZGm7A",
                duration = 1100,
                about = "Explore the history of ancient civilizations, from Mesopotamia to Ancient Egypt, and their lasting impact on modern culture.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/rise_of_ancient_civilizations.png"
            ),
            Video(
                id = 205,
                courseId = 207,
                title = "The Influence of Greek and Roman Culture",
                url = "https://www.youtube.com/watch?v=1_2UasFybiE",
                duration = 1200,
                about = "Learn about the cultural, political, and intellectual legacy of Greek and Roman civilizations.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/greek_roman_culture.png"
            ),
            Video(
                id = 206,
                courseId = 208,
                title = "The Art of Storytelling",
                url = "https://www.youtube.com/watch?v=Nj-hdQMa3uA",
                duration = 1000,
                about = "Discover the fundamentals of storytelling and how to craft compelling narratives in any genre.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/art_of_storytelling.png"
            ),
            Video(
                id = 207,
                courseId = 208,
                title = "Poetry and Prose Techniques",
                url = "https://www.youtube.com/watch?v=ha1NneZGm7A",
                duration = 950,
                about = "Learn techniques for writing poetry and prose, including structure, rhythm, and emotional impact.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/poetry_prose_techniques.png"
            ),
            Video(
                id = 220,
                courseId = 209,
                title = "Introduction to Language Learning",
                url = "https://www.youtube.com/watch?v=Goq_qIKojTU&t=239s",
                duration = 1000,
                about = "An overview of effective language learning methods and how to start mastering a new language.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/introduction_language_learning.png"
            ),
            Video(
                id = 221,
                courseId = 209,
                title = "Essential Vocabulary for Beginners",
                url = "https://www.youtube.com/watch?v=jkDQIcEMHC8",
                duration = 1100,
                about = "Learn the most important vocabulary for beginners in your new language.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/essential_vocabulary.png"
            ),
            Video(
                id = 222,
                courseId = 209,
                title = "Grammar Basics for New Learners",
                url = "https://www.youtube.com/watch?v=Goq_qIKojTU&t=239s",
                duration = 1200,
                about = "Understand the fundamental grammar rules for beginners to speak and write confidently.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/grammar_basics.png"
            ),
            Video(
                id = 223,
                courseId = 209,
                title = "Pronunciation Practice",
                url = "https://www.youtube.com/watch?v=jkDQIcEMHC8",
                duration = 1050,
                about = "Learn essential pronunciation tips to improve your speaking skills in your new language.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/pronunciation_practice.png"
            ),
            Video(
                id = 224,
                courseId = 210,
                title = "Introduction to Educational Psychology",
                url = "https://www.youtube.com/watch?v=vo4pMVb0R6M",
                duration = 950,
                about = "Discover the psychological theories that inform modern educational practices.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/intro_to_psychology.png"
            ),
            Video(
                id = 225,
                courseId = 210,
                title = "Understanding Student Behavior",
                url = "https://www.youtube.com/watch?v=S3YJrjqfd64",
                duration = 1100,
                about = "Learn how to understand and address the behavior of students in the classroom.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/student_behavior.png"
            ),
            Video(
                id = 226,
                courseId = 210,
                title = "Cognitive Development in Children",
                url = "https://www.youtube.com/watch?v=S3YJrjqfd64",
                duration = 1200,
                about = "Learn how children's cognitive abilities develop and how to cater to their learning needs.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/cognitive_development.png"
            ),
            Video(
                id = 227,
                courseId = 210,
                title = "Engagement Strategies for Teachers",
                url = "https://www.youtube.com/watch?v=Q5tdBOg8kus",
                duration = 1150,
                about = "Discover strategies to keep students engaged and actively participating in lessons.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/engagement_strategies.png"
            ),
            Video(
                id = 228,
                courseId = 211,
                title = "Advanced Reading Techniques",
                url = "https://www.youtube.com/watch?v=F912Y5RkmnY",
                duration = 1050,
                about = "Learn advanced techniques for efficient reading and information retention.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/advanced_reading.png"
            ),
            Video(
                id = 229,
                courseId = 211,
                title = "Effective Note-Taking Strategies",
                url = "https://www.youtube.com/watch?v=VAPgP3ONJVo&t=218s",
                duration = 1000,
                about = "Master the art of note-taking to improve comprehension and retention during lectures.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/note_taking_strategies.png"
            ),
            Video(
                id = 230,
                courseId = 211,
                title = "Time Management for Effective Study",
                url = "https://www.youtube.com/watch?v=F912Y5RkmnY",
                duration = 1100,
                about = "Learn how to manage your time effectively for optimal study results.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/time_management_study.png"
            ),
            Video(
                id = 231,
                courseId = 211,
                title = "Memory Improvement Techniques",
                url = "https://www.youtube.com/watch?v=VAPgP3ONJVo&t=218s",
                duration = 1150,
                about = "Discover techniques to enhance memory and improve recall for academic success.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/memory_improvement.png"
            ),
            Video(
                id = 432,
                courseId = 230,
                title = "Introduction to Advanced Java",
                url = "https://www.youtube.com/watch?v=RRubcjpTkks",
                duration = 1200,
                about = "Dive into advanced concepts of Java programming, from multi-threading to file handling.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/intro_advanced_java.png"
            ),
            Video(
                id = 433,
                courseId = 230,
                title = "Multi-threading in Java",
                url = "https://www.youtube.com/watch?v=r_MbozD32eo",
                duration = 1300,
                about = "Understand multi-threading in Java, including thread creation, synchronization, and concurrency.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/multithreading_java.png"
            ),
            Video(
                id = 434,
                courseId = 230,
                title = "File Handling in Java",
                url = "https://www.youtube.com/watch?v=ScUJx4aWRi0",
                duration = 1400,
                about = "Learn to handle files in Java, including reading and writing data to text and binary files.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/file_handling_java.png"
            ),
            Video(
                id = 435,
                courseId = 230,
                title = "Design Patterns in Java",
                url = "https://www.youtube.com/watch?v=tAuRQs_d9F8",
                duration = 1450,
                about = "Explore common design patterns in Java such as Singleton, Factory, and Observer patterns.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/design_patterns_java.png"
            ),
            Video(
                id = 436,
                courseId = 230,
                title = "Exception Handling in Java",
                url = "https://www.youtube.com/watch?v=1XAfapkBQjk",
                duration = 1200,
                about = "Master Java exception handling with try-catch blocks, custom exceptions, and exception hierarchies.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/exception_handling_java.png"
            ),
            Video(
                id = 437,
                courseId = 231,
                title = "Introduction to React",
                url = "https://www.youtube.com/watch?v=Tn6-PIqc4UM&t=70s",
                duration = 1100,
                about = "Get started with React by understanding components, JSX, and props.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/intro_to_react.png"
            ),
            Video(
                id = 438,
                courseId = 231,
                title = "React State Management",
                url = "https://www.youtube.com/watch?v=VenLRGHx3D4",
                duration = 1200,
                about = "Learn how to manage state in React using useState, useReducer, and context API.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/react_state_management.png"
            ),
            Video(
                id = 439,
                courseId = 231,
                title = "React Component Architecture",
                url = "https://www.youtube.com/watch?v=Tn6-PIqc4UM&t=70s",
                duration = 1300,
                about = "Understand how to structure your React application using component-based architecture.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/react_component_architecture.png"
            ),
            Video(
                id = 440,
                courseId = 231,
                title = "React Hooks: useEffect and useContext",
                url = "https://www.youtube.com/watch?v=Tn6-PIqc4UM&t=70s",
                duration = 1250,
                about = "Learn how to use React hooks like useEffect and useContext to manage side effects and context in your application.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/react_hooks.png"
            ),
            Video(
                id = 441,
                courseId = 231,
                title = "React Router for Navigation",
                url = "https://www.youtube.com/watch?v=Tn6-PIqc4UM&t=70s",
                duration = 1150,
                about = "Implement routing in your React app using React Router for seamless navigation between pages.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/react_router_navigation.png"
            ),
            Video(
                id = 450,
                courseId = 232,
                title = "Introduction to Python for Data Science",
                url = "https://www.youtube.com/watch?v=Rt1junWNj7k",
                duration = 1000,
                about = "Learn the basics of Python programming and how it applies to data science.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/intro_python_datascience.png"
            ),
            Video(
                id = 451,
                courseId = 232,
                title = "Using Pandas for Data Manipulation",
                url = "https://www.youtube.com/watch?v=bDhvCp3_lYw",
                duration = 1200,
                about = "Master data manipulation using the Pandas library in Python for effective analysis.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/pandas_data_manipulation.png"
            ),
            Video(
                id = 452,
                courseId = 232,
                title = "Data Visualization with Matplotlib",
                url = "https://www.youtube.com/watch?v=a9UrKTVEeZA",
                duration = 1300,
                about = "Learn how to create powerful data visualizations with Matplotlib to represent your data.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/matplotlib_visualization.png"
            ),
            Video(
                id = 453,
                courseId = 232,
                title = "Building Machine Learning Models in Python",
                url = "https://www.youtube.com/watch?v=29ZQ3TDGgRQ",
                duration = 1400,
                about = "Learn to build machine learning models using Python libraries like Scikit-Learn.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/machine_learning_models.png"
            ),
            Video(
                id = 454,
                courseId = 232,
                title = "Advanced Data Analysis Techniques",
                url = "https://www.youtube.com/watch?v=-mvVOYrQs0s",
                duration = 1500,
                about = "Explore advanced techniques for analyzing data and solving complex problems.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/advanced_data_analysis.png"
            ),
            Video(
                id = 455,
                courseId = 233,
                title = "Introduction to Flutter",
                url = "https://www.youtube.com/watch?v=1xipg02Wu8s",
                duration = 1100,
                about = "Get started with Flutter by learning its components and structure for mobile app development.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/intro_flutter.png"
            ),
            Video(
                id = 456,
                courseId = 233,
                title = "Setting Up Your Flutter Development Environment",
                url = "https://www.youtube.com/watch?v=D4nhaszNW4o",
                duration = 1200,
                about = "Learn how to set up your environment to start building Flutter apps on iOS and Android.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/setup_flutter_environment.png"
            ),
            Video(
                id = 457,
                courseId = 233,
                title = "Building a Simple Mobile App with Flutter",
                url = "https://www.youtube.com/watch?v=1xipg02Wu8s",
                duration = 1300,
                about = "Create a simple mobile app using Flutter to understand its core components and architecture.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/build_simple_app_flutter.png"
            ),
            Video(
                id = 458,
                courseId = 233,
                title = "Flutter Widgets and UI Design",
                url = "https://www.youtube.com/watch?v=1xipg02Wu8s",
                duration = 1350,
                about = "Master the use of Flutter widgets to build interactive and responsive user interfaces.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/flutter_widgets_ui.png"
            ),
            Video(
                id = 459,
                courseId = 233,
                title = "Deploying Flutter Apps to iOS and Android",
                url = "https://www.youtube.com/watch?v=D4nhaszNW4o",
                duration = 1400,
                about = "Learn how to deploy your Flutter app to both iOS and Android platforms.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/deploy_flutter_apps.png"
            ),
            Video(
                id = 467,
                courseId = 234,
                title = "Getting Started with AWS Cloud",
                url = "https://www.youtube.com/watch?v=ubCNZRNjhyo",
                duration = 1200,
                about = "Learn the basics of AWS and how to set up your first cloud environment for scalability and security.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/aws_cloud_intro.png"
            ),
            Video(
                id = 468,
                courseId = 235,
                title = "Introduction to Git and GitHub",
                url = "https://www.youtube.com/watch?v=tRZGeaHPoaw",
                duration = 1100,
                about = "Get an overview of Git and GitHub, including how to use Git for version control and collaborate on GitHub.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/git_github_intro.png"
            ),
            Video(
                id = 498,
                courseId = 236,
                title = "What is Artificial Intelligence?",
                url = "https://www.youtube.com/watch?v=ad79nYk2keg",
                duration = 900,
                about = "Introduction to the basics of AI, its history, and its applications in modern technology.",
                order = 1,
                thumbnailUrl = "https://example.com/thumbnails/ai_intro.png"
            ),
            Video(
                id = 499,
                courseId = 236,
                title = "Setting Up Python for AI Development",
                url = "https://www.youtube.com/watch?v=yTJxDzqo4fQ",
                duration = 1000,
                about = "Learn how to set up Python and the essential libraries (NumPy, Pandas, etc.) for AI projects.",
                order = 2,
                thumbnailUrl = "https://example.com/thumbnails/python_setup.png"
            ),
            Video(
                id = 500,
                courseId = 236,
                title = "Understanding Machine Learning Algorithms",
                url = "https://www.youtube.com/watch?v=aircAruvnKk",
                duration = 1200,
                about = "Explore various machine learning algorithms such as regression, classification, and clustering.",
                order = 3,
                thumbnailUrl = "https://example.com/thumbnails/ml_algorithms.png"
            ),
            Video(
                id = 501,
                courseId = 236,
                title = "Deep Learning Basics with Neural Networks",
                url = "https://www.youtube.com/watch?v=aircAruvnKk",
                duration = 1300,
                about = "Introduction to deep learning, covering neural networks and their role in AI applications.",
                order = 4,
                thumbnailUrl = "https://example.com/thumbnails/neural_networks.png"
            ),
            Video(
                id = 502,
                courseId = 236,
                title = "Building Your First AI Model in Python",
                url = "https://www.youtube.com/watch?v=yTJxDzqo4fQ",
                duration = 1400,
                about = "Step-by-step guide on creating and training your first machine learning model using Python.",
                order = 5,
                thumbnailUrl = "https://example.com/thumbnails/building_model.png"
            )
        )
        database.videoDao().insertAll(videoList)
    }
}