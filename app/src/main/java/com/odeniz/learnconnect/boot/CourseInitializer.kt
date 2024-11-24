package com.odeniz.learnconnect.boot

import com.odeniz.learnconnect.entity.Course
import com.odeniz.learnconnect.local.AppDatabase

object CourseInitializer {
    fun initializeCourses(database: AppDatabase) {
        val courses = listOf(
            Course(
                id = 12,
                title = "Java for Beginners",
                description = "Learn the basics of Java programming, including syntax, variables, loops, and object-oriented programming concepts.",
                thumbnailUrl = "https://media.geeksforgeeks.org/wp-content/cdn-uploads/20230630120510/How-to-Start-Learning-Java.png",
                averageRating = 4.5f,
                ratingCount = 150,
                categoryId = 1,
                subTags = "Java,Programming,Basics,OOP"
            ),
            Course(
                id = 13,
                title = "Mastering Python",
                description = "Comprehensive course on Python, covering data structures, file handling, modules, and advanced libraries like NumPy and Pandas.",
                thumbnailUrl = "https://rooman.net/wp-content/uploads/2023/12/bf43ab84thumbnail.jpeg",
                averageRating = 4.8f,
                ratingCount = 230,
                categoryId = 1,
                subTags = "Python,Programming,Data Analysis,Machine Learning"
            ),
            Course(
                id = 14,
                title = "Web Development Bootcamp",
                description = "Learn full-stack web development, including HTML, CSS, JavaScript, Node.js, and React.",
                thumbnailUrl = "https://process.fs.teachablecdn.com/ADNupMnWyR7kCWRvm76Laz/resize=width:705/https://www.filepicker.io/api/file/FSIjaoI2QtKWZL65cogd",
                averageRating = 4.7f,
                ratingCount = 300,
                categoryId = 1,
                subTags = "Web Development,HTML,CSS,JavaScript,React,Node.js"
            ),
            Course(
                id = 15,
                title = "Kotlin for Android Developers",
                description = "Learn Kotlin from scratch and build your first Android app. Covers layouts, activities, and integrating APIs.",
                thumbnailUrl = "https://miro.medium.com/v2/resize:fit:624/1*jeQt0Xwl5WrPPgGFFdvnDQ.png",
                averageRating = 4.6f,
                ratingCount = 180,
                categoryId = 1,
                subTags = "Kotlin,Android Development,Mobile Development,APIs"
            ),
            Course(
                id = 16,
                title = "Data Structures and Algorithms in C++",
                description = "Master data structures and algorithms using C++, including arrays, linked lists, trees, and dynamic programming.",
                thumbnailUrl = "https://i.ytimg.com/vi/B31LgI4Y4DQ/maxresdefault.jpg",
                averageRating = 4.8f,
                ratingCount = 210,
                categoryId = 1,
                subTags = "Data Structures,Algorithms,C++,Dynamic Programming,Problem Solving"
            ),
            Course(
                id = 17,
                title = "Introduction to Machine Learning",
                description = "Explore machine learning concepts using Python, including supervised and unsupervised learning, and tools like Scikit-learn.",
                thumbnailUrl = "https://miro.medium.com/v2/resize:fit:1400/1*cG6U1qstYDijh9bPL42e-Q.jpeg",
                averageRating = 4.9f,
                ratingCount = 320,
                categoryId = 1,
                subTags = "Machine Learning,Python,Data Science,AI,Scikit-learn"
            ),
            Course(
                id = 21,
                title = "Introduction to Microeconomics",
                description = "Understand the fundamentals of microeconomics, including supply and demand, market structures, and consumer behavior.",
                thumbnailUrl = "https://googlesir.com/wp-content/uploads/2018/02/15194702696441.jpg",
                averageRating = 4.6f,
                ratingCount = 200,
                categoryId = 2,
                subTags = "Economics,Microeconomics,Supply and Demand,Markets,Consumer Behavior"
            ),
            Course(
                id = 22,
                title = "Mastering Financial Markets",
                description = "Learn how financial markets work, including stocks, bonds, and derivatives. Explore strategies for trading and investment.",
                thumbnailUrl = "https://fastercapital.co/i/The-Dow-Jones-65-and-Beyond--Navigating-the-World-of-Financial-Markets--Mastering-the-Art-of-Financial-Market-Navigation.webp",
                averageRating = 4.7f,
                ratingCount = 180,
                categoryId = 2,
                subTags = "Financial Markets,Stocks,Bonds,Investment,Trading"
            ),
            Course(
                id = 23,
                title = "Principles of Macroeconomics",
                description = "Explore macroeconomic principles such as GDP, inflation, unemployment, and fiscal policies in a global context.",
                thumbnailUrl = "https://openeducation.gatech.edu/wp-content/uploads/2020/12/CTLMacroV3.png",
                averageRating = 4.8f,
                ratingCount = 220,
                categoryId = 2,
                subTags = "Economics,Macroeconomics,GDP,Inflation,Fiscal Policies,Global Economy"
            ),
            Course(
                id = 24,
                title = "Investment Strategies for Beginners",
                description = "Learn the basics of investing, including portfolio management, risk assessment, and the power of compound interest.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROBYhusPa6zf_HazV4z0xcEMfv5PMU7ztb3g&s",
                averageRating = 4.5f,
                ratingCount = 150,
                categoryId = 2,
                subTags = "Investment,Risk Management,Portfolio Management,Compound Interest,Wealth Building"
            ), Course(
                id = 51,
                title = "Nutrition Basics",
                description = "Learn the fundamentals of nutrition, including macronutrients, vitamins, and healthy eating habits.",
                thumbnailUrl = "https://www.drnitingupte.com/wp-content/uploads/2019/10/img_0795-1.jpg",
                averageRating = 4.7f,
                ratingCount = 140,
                categoryId = 3,
                subTags = "Nutrition,Healthy Eating,Vitamins,Macronutrients,Diet"
            ), Course(
                id = 52,
                title = "Yoga for Beginners",
                description = "Discover basic yoga poses and breathing techniques to improve flexibility and reduce stress.",
                thumbnailUrl = "https://www.yogabasics.com/yogabasics2017/wp-content/uploads/2023/02/How-to-Learn-Yoga-Poses.jpg",
                averageRating = 4.8f,
                ratingCount = 200,
                categoryId = 3,
                subTags = "Yoga,Flexibility,Stress Relief,Health,Wellness"
            ),
            Course(
                id = 53,
                title = "Mental Health Awareness",
                description = "Understand mental health concepts, common disorders, and strategies to maintain psychological well-being.",
                thumbnailUrl = "https://www.jkcf.org/wp-content/uploads/2023/05/mental-health-month-1024x576.png",
                averageRating = 4.6f,
                ratingCount = 180,
                categoryId = 3,
                subTags = "Mental Health,Psychology,Well-being,Awareness,Stress Management"
            ),
            Course(
                id = 54,
                title = "Home Workouts for All Levels",
                description = "Learn effective workout routines you can do at home without any equipment.",
                thumbnailUrl = "https://180vsme.com/wp-content/uploads/2023/11/10-Minute-Lower-Body-Workout.jpg",
                averageRating = 4.5f,
                ratingCount = 170,
                categoryId = 3,
                subTags = "Fitness,Home Workouts,Exercise,Health,Strength Training"
            ),
            Course(
                id = 55,
                title = "Introduction to Meditation",
                description = "Discover the basics of meditation and how to incorporate mindfulness into daily life.",
                thumbnailUrl = "https://oif.org/wp-content/uploads/2021/05/meditation.png",
                averageRating = 4.9f,
                ratingCount = 250,
                categoryId = 3,
                subTags = "Meditation,Mindfulness,Relaxation,Stress Relief,Health"
            ),
            Course(
                id = 56,
                title = "Cardio for Weight Loss",
                description = "Learn the best cardio exercises to burn calories and maintain a healthy weight.",
                thumbnailUrl = "https://180vsme.com/wp-content/uploads/2023/11/10-Minute-Lower-Body-Workout.jpg",
                averageRating = 4.7f,
                ratingCount = 210,
                categoryId = 3,
                subTags = "Cardio,Weight Loss,Fitness,Health,Calorie Burning"
            ),
            Course(
                id = 57,
                title = "Understanding Human Anatomy",
                description = "Explore the human body's structure and functions, from organs to systems.",
                thumbnailUrl = "https://www.freedomhealthinsurance.co.uk/getmedia/116c567d-16db-44af-acf5-c19e2871e841/blog-image_2",
                averageRating = 4.8f,
                ratingCount = 190,
                categoryId = 3,
                subTags = "Anatomy,Health,Body Systems,Biology,Education"
            ),
            Course(
                id = 58,
                title = "Healthy Cooking Made Easy",
                description = "Learn how to prepare nutritious and delicious meals at home.",
                thumbnailUrl = "https://i.ytimg.com/vi/b53j0ucPRFI/maxresdefault.jpg",
                averageRating = 4.6f,
                ratingCount = 160,
                categoryId = 3,
                subTags = "Cooking,Healthy Recipes,Nutrition,Health,Wellness"
            ),
            Course(
                id = 59,
                title = "First Aid Essentials",
                description = "Gain essential first aid knowledge to handle common medical emergencies.",
                thumbnailUrl = "https://centurylinen.com/wp-content/uploads/2019/02/firstaidkit-1.jpg",
                averageRating = 4.7f,
                ratingCount = 220,
                categoryId = 3,
                subTags = "First Aid,Medical Emergencies,Health,Safety,CPR"
            ),
            Course(
                id = 60,
                title = "Stress Management Techniques",
                description = "Learn effective techniques to manage stress and improve overall well-being.",
                thumbnailUrl = "https://miro.medium.com/v2/resize:fit:706/0*cqNGmxJqT8zPAn8C.png",
                averageRating = 4.8f,
                ratingCount = 200,
                categoryId = 3,
                subTags = "Stress Management,Mindfulness,Health,Well-being,Relaxation"
            ),
            Course(
                id = 80,
                title = "Time Management Mastery",
                description = "Learn effective time management techniques to increase productivity and achieve your goals.",
                thumbnailUrl = "https://img-c.udemycdn.com/course/750x422/2042514_d265.jpg",
                averageRating = 4.7f,
                ratingCount = 190,
                categoryId = 4,
                subTags = "Time Management,Productivity,Personal Development,Goal Setting"
            ),
            Course(
                id = 81,
                title = "Public Speaking Confidence",
                description = "Develop skills to deliver powerful and confident speeches in any setting.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReOtAgBGnZnW4Y-sw3vyHo2Og-504_vHH5-A&s",
                averageRating = 4.8f,
                ratingCount = 220,
                categoryId = 4,
                subTags = "Public Speaking,Communication,Confidence,Personal Development"
            ),
            Course(
                id = 82,
                title = "Emotional Intelligence 101",
                description = "Understand and enhance your emotional intelligence to build better relationships.",
                thumbnailUrl = "https://leaveboard.com/static/what-is-emotional-intelligence-ba89ccd3e140c6f9a7fdf3062f89b9df.png",
                averageRating = 4.6f,
                ratingCount = 180,
                categoryId = 4,
                subTags = "Emotional Intelligence,Relationships,Personal Development,Self Awareness"
            ),

            Course(
                id = 83,
                title = "Building Self-Discipline",
                description = "Learn strategies to develop self-discipline and stay motivated to achieve your personal and professional goals.",
                thumbnailUrl = "https://i.ytimg.com/vi/Ul0uQrFZNAs/maxresdefault.jpg",
                averageRating = 4.7f,
                ratingCount = 200,
                categoryId = 4,
                subTags = "Self Discipline,Motivation,Goal Setting,Personal Development"
            ),
            Course(
                id = 84,
                title = "Mindfulness for Everyday Life",
                description = "Discover practical mindfulness techniques to reduce stress and improve your focus and well-being.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVXkR0CPV7gmen9W4XrWyh8XK3R3SVSXFWrQ&s",
                averageRating = 4.9f,
                ratingCount = 240,
                categoryId = 4,
                subTags = "Mindfulness,Stress Relief,Focus,Personal Development"
            ),
            Course(
                id = 101,
                title = "Guitar for Beginners",
                description = "Learn the basics of guitar playing, including chords, strumming, and simple songs.",
                thumbnailUrl = "https://images.ctfassets.net/r1mvpfown1y6/1lClvGY2zGnQzc1VBB1KBk/4eb170a7acdb6b3e3145e7c26c3baf8a/CD60_v3.jpeg",
                averageRating = 4.7f,
                ratingCount = 150,
                categoryId = 5,
                subTags = "Guitar,Music,Chords,Beginners,Instruments"
            ),
            Course(
                id = 102,
                title = "Mastering Music Theory",
                description = "Understand the fundamentals of music theory, including scales, harmony, and rhythm.",
                thumbnailUrl = "https://www.musical-u.com/wp-content/uploads/2016/10/The-Secret-to-Mastering-Music-Theory-1.jpg",
                averageRating = 4.8f,
                ratingCount = 180,
                categoryId = 5,
                subTags = "Music Theory,Harmony,Scales,Rhythm,Music Education"
            ),
            Course(
                id = 103,
                title = "Vocal Training for Singers",
                description = "Improve your vocal technique, pitch, and breath control with professional exercises.",
                thumbnailUrl = "https://cdn.schoolofrock.com/img/content-module-single/how-to-sing-from-diaphragm-1559238347.png",
                averageRating = 4.9f,
                ratingCount = 200,
                categoryId = 5,
                subTags = "Vocal Training,Singing,Pitch,Breath Control,Music"
            ),
            Course(
                id = 104,
                title = "Introduction to Music Production",
                description = "Learn the essentials of music production, including recording, mixing, and editing tracks.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwlHcX9LYC-xw2AGmhrOalrjUsXqA3E4jCUw&s",
                averageRating = 4.6f,
                ratingCount = 170,
                categoryId = 5,
                subTags = "Music Production,Recording,Mixing,Editing,Music Technology"
            ),
            Course(
                id = 120,
                title = "Drawing for Beginners",
                description = "Learn basic drawing techniques, including shading, perspective, and composition.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQL3ClvJjv2MUA08KUYZ0P30vzMNKc3XZFWVg&s",
                averageRating = 4.7f,
                ratingCount = 140,
                categoryId = 6,
                subTags = "Drawing,Art,Shading,Perspective,Sketching"
            ),
            Course(
                id = 121,
                title = "Introduction to Digital Painting",
                description = "Explore digital painting tools and techniques to create stunning artwork using your tablet or computer.",
                thumbnailUrl = "https://i.ytimg.com/vi/--GmtSXO0jY/sddefault.jpg",
                averageRating = 4.8f,
                ratingCount = 180,
                categoryId = 6,
                subTags = "Digital Painting,Art,Illustration,Creativity,Graphic Design"
            ),
            Course(
                id = 122,
                title = "Watercolor Techniques",
                description = "Master the art of watercolor painting with step-by-step guidance on blending and layering colors.",
                thumbnailUrl = "https://shop.zenartsupplies.co/cdn/shop/articles/HEADER-5_1024x1024.jpg?v=1645189496",
                averageRating = 4.6f,
                ratingCount = 160,
                categoryId = 6,
                subTags = "Watercolor,Painting,Art,Blending,Color Theory"
            ),
            Course(
                id = 130,
                title = "Travel Planning Essentials",
                description = "Learn how to plan your trips efficiently, including budgeting, itinerary creation, and packing tips.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3zK0vhhDUe9bchbSCSKPYpoFaTQcGfYJ8Hw&s",
                averageRating = 4.7f,
                ratingCount = 120,
                categoryId = 9,
                subTags = "Travel Planning,Budgeting,Itinerary,Packing,Tips"
            ),

            Course(
                id = 131,
                title = "Exploring Cultural Heritage",
                description = "Discover how to immerse yourself in local cultures and traditions while traveling.",
                thumbnailUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEia4gFyjSaZU6qHRKt8WEYThQtrEwSuyoDseZQXj4R5y9oOvrZV4K3BOxpqRe11P9tVxnWwscN9Dcsl9EwD728DiZijY7wX0Tw_g2Jfd-zUQZX1ML92qNDBfATKEV50FMHToaBhA74EFnA/s1600/images+%25289%2529.jpg",
                averageRating = 4.8f,
                ratingCount = 150,
                categoryId = 9,
                subTags = "Cultural Heritage,Travel,Local Traditions,Immersion,Adventure"
            ),
            Course(
                id = 132,
                title = "Solo Travel Guide",
                description = "Learn tips and tricks for safe and enjoyable solo travel adventures.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3zK0vhhDUe9bchbSCSKPYpoFaTQcGfYJ8Hw&s",
                averageRating = 4.6f,
                ratingCount = 140,
                categoryId = 9,
                subTags = "Solo Travel,Safety,Tips,Adventure,Independence"
            ),
            Course(
                id = 133,
                title = "Photography for Travelers",
                description = "Enhance your travel photography skills to capture breathtaking moments during your trips.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrpKcpccG5Gu_HZFnEE2BgGDyVGB1f3E8dGQ&s",
                averageRating = 4.9f,
                ratingCount = 180,
                categoryId = 9,
                subTags = "Photography,Travel,Adventure,Skills,Capture Moments"
            ),
            Course(
                id = 134,
                title = "Sustainable Tourism",
                description = "Understand how to travel responsibly and minimize your environmental impact.",
                thumbnailUrl = "https://www.gelecekturizmde.com/wp-content/uploads/2018/12/slider-1.jpg",
                averageRating = 4.7f,
                ratingCount = 130,
                categoryId = 9,
                subTags = "Sustainable Tourism,Travel,Environment,Responsibility,Green Travel"
            ),
            Course(
                id = 150,
                title = "Introduction to Football",
                description = "Learn the basic rules, techniques, and strategies of playing football (soccer).",
                thumbnailUrl = "https://i.ytimg.com/vi/TEYfKPAx3d4/maxresdefault.jpg",
                averageRating = 4.8f,
                ratingCount = 200,
                categoryId = 7,
                subTags = "Football,Soccer,Basic Rules,Techniques,Strategy"
            ),

            Course(
                id = 151,
                title = "Basketball Fundamentals",
                description = "Master the fundamentals of basketball, including dribbling, shooting, and team strategies.",
                thumbnailUrl = "https://www.basketballforcoaches.com/wp-content/uploads/2019/11/basketball-fundamentals.jpg",
                averageRating = 4.7f,
                ratingCount = 180,
                categoryId = 7,
                subTags = "Basketball,Fundamentals,Shooting,Dribbling,Team Play"
            ),
            Course(
                id = 152,
                title = "Yoga for Athletes",
                description = "Improve flexibility, balance, and strength with yoga techniques tailored for athletes.",
                thumbnailUrl = "https://d2cyblhgq88dk3.cloudfront.net/uploads/article/image/74/large_Blog-Yoga-Athlete.jpeg",
                averageRating = 4.9f,
                ratingCount = 220,
                categoryId = 7,
                subTags = "Yoga,Athletes,Flexibility,Balance,Strength"
            ),
            Course(
                id = 153,
                title = "Running Techniques for Beginners",
                description = "Learn proper running form, warm-ups, and techniques to build endurance and prevent injuries.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0CplFG7J8V4bCengze0UzDVz1gGdpdDcgHw&s",
                averageRating = 4.6f,
                ratingCount = 170,
                categoryId = 7,
                subTags = "Running,Techniques,Endurance,Injury Prevention,Beginners"
            ),
            Course(
                id = 200,
                title = "Effective Study Techniques",
                description = "Learn proven methods to enhance your study habits and retain information more effectively.",
                thumbnailUrl = "https://miro.medium.com/v2/resize:fit:1400/1*gbaHRDeP4Tn_RS96bomqDg.png",
                averageRating = 4.7f,
                ratingCount = 250,
                categoryId = 8,
                subTags = "Study,Techniques,Learning,Retention,Education"
            ),
            Course(
                id = 201,
                title = "Time Management for Students",
                description = "Master time management skills to balance your academic, personal, and extracurricular activities.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX_m1giWfq1S9Y1Sz9fYay1XbpPM3fAH42GQ&s",
                averageRating = 4.8f,
                ratingCount = 220,
                categoryId = 8,
                subTags = "Time Management,Students,Productivity,Focus,Education"
            ),
            Course(
                id = 202,
                title = "Critical Thinking Skills",
                description = "Develop critical thinking abilities to analyze, evaluate, and solve problems more effectively.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj4fmo89pwP0-942Q0aOjrUN9jHvjJR2NE9A&s",
                averageRating = 4.9f,
                ratingCount = 180,
                categoryId = 8,
                subTags = "Critical Thinking,Problem Solving,Analysis,Education"
            ),
            Course(
                id = 203,
                title = "Learning Strategies for Kids",
                description = "Fun and engaging learning strategies to help kids master new concepts and build strong foundations.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvlYFBUxxAc52ykrdyoT-fo98ejaoKv70d7A&s",
                averageRating = 4.6f,
                ratingCount = 200,
                categoryId = 8,
                subTags = "Kids,Learning,Strategies,Education,Children"
            ),
            Course(
                id = 204,
                title = "Public Speaking for Students",
                description = "Gain confidence and master the art of public speaking to excel in presentations and speeches.",
                thumbnailUrl = "https://www.collegetransitions.com/wp-content/uploads/2023/06/blog-10waystoimproveyourpublicspeakingskills-1460x822-1.webp",
                averageRating = 4.8f,
                ratingCount = 210,
                categoryId = 8,
                subTags = "Public Speaking,Presentation,Confidence,Education"
            ),
            Course(
                id = 205,
                title = "Introduction to Online Learning",
                description = "Get comfortable with online learning platforms and tools to succeed in virtual classrooms.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbm2qt8qS_53zqNI_xYwbCJvxx-eBfl_Ep0g&s",
                averageRating = 4.7f,
                ratingCount = 180,
                categoryId = 8,
                subTags = "Online Learning,Virtual Classrooms,Education,Technology"
            ),
            Course(
                id = 206,
                title = "Mathematics for High School Students",
                description = "Master high school math concepts, from algebra to calculus, with easy-to-follow lessons and examples.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvYxx-IyR_ErGRpZ9ykfkpx7nMbHo7SDFzng&s",
                averageRating = 4.9f,
                ratingCount = 220,
                categoryId = 8,
                subTags = "Mathematics,High School,Algebra,Calculus,Education"
            ),
            Course(
                id = 207,
                title = "History and Culture for Students",
                description = "Explore the history and culture of different civilizations to build a strong understanding of the world.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRB3RnHGxamsHbbiCa80xLwivkKnhyQABe8Bg&s",
                averageRating = 4.6f,
                ratingCount = 190,
                categoryId = 8,
                subTags = "History,Culture,Education,Social Studies"
            ),
            Course(
                id = 208,
                title = "Creative Writing for Beginners",
                description = "Unlock your creativity and learn the basics of writing stories, poems, and essays.",
                thumbnailUrl = "https://media.licdn.com/dms/image/v2/D4E12AQHFOtYOQ7MzHQ/article-cover_image-shrink_600_2000/article-cover_image-shrink_600_2000/0/1679945931719?e=2147483647&v=beta&t=Sw7Gc-JkALlt_cQqvT6A-rWafX0IG6Il8fPOnXfih7c",
                averageRating = 4.7f,
                ratingCount = 170,
                categoryId = 8,
                subTags = "Creative Writing,Storytelling,Poetry,Education"
            ),
            Course(
                id = 209,
                title = "Learning a New Language",
                description = "Pick up essential language skills in a fun and effective way with this beginner-friendly course.",
                thumbnailUrl = "https://victorseducation.com/wp-content/uploads/2021/05/learn-a-new-language-flags-1068x713-1.jpg",
                averageRating = 4.8f,
                ratingCount = 210,
                categoryId = 8,
                subTags = "Language Learning,Beginner,Education,Communication"
            ),
            Course(
                id = 210,
                title = "Educational Psychology for Teachers",
                description = "Understand the psychology behind effective teaching and learning to improve student engagement.",
                thumbnailUrl = "https://cdn-hkbbb.nitrocdn.com/QTCJbUazKnWUNTVqagKZShXFbBtZByZg/assets/images/optimized/rev-3f0a91b/www.cadabamshospitals.com/wp-content/uploads/2020/10/School-teacher%E2%80%99s-guide-to-Child-Psychology.png",
                averageRating = 4.6f,
                ratingCount = 180,
                categoryId = 8,
                subTags = "Psychology,Teaching,Education,Engagement"
            ),
            Course(
                id = 211,
                title = "Advanced Study Skills",
                description = "Learn advanced study strategies to optimize your learning and improve academic performance.",
                thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFabrXJ9o6TUPdWS7WwldW0RzGbnj00QmwaA&s",
                averageRating = 4.7f,
                ratingCount = 250,
                categoryId = 8,
                subTags = "Study Skills,Advanced Learning,Education"
            ),
            Course(
                id = 230,
                title = "Advanced Java Programming",
                description = "Dive deep into Java programming concepts including multi-threading, file handling, and advanced design patterns.",
                thumbnailUrl = "https://media.geeksforgeeks.org/wp-content/uploads/20230823152056/What-is-Advance-JAVA.png",
                averageRating = 4.9f,
                ratingCount = 250,
                categoryId = 1,
                subTags = "Java,Advanced Programming,Multi-threading,Design Patterns"
            ),

            Course(
                id = 231,
                title = "Web Development with React",
                description = "Learn to build modern web applications using React, including component-based architecture and state management.",
                thumbnailUrl = "https://www.htmlpanda.com/blog/wp-content/uploads/2022/05/A-Guide-on-ReactJS-Web-Development-1.png",
                averageRating = 4.8f,
                ratingCount = 200,
                categoryId = 1,
                subTags = "React,Web Development,JavaScript,Front-End,UI"
            ),
            Course(
                id = 232,
                title = "Mastering Python for Data Science",
                description = "Learn how to use Python to perform data analysis, build machine learning models, and visualize data with libraries like Pandas and Matplotlib.",
                thumbnailUrl = "https://miro.medium.com/v2/resize:fit:1200/1*dLvNbetmU4FpxvPwfV-ucg.jpeg",
                averageRating = 4.1f,
                ratingCount = 220,
                categoryId = 1,
                subTags = "Python,Data Science,Machine Learning,Pandas,Data Analysis"
            ),
            Course(
                id = 233,
                title = "Building Mobile Apps with Flutter",
                description = "Master the art of mobile app development using Flutter, and build beautiful and responsive apps for both iOS and Android.",
                thumbnailUrl = "",
                averageRating = 4.6f,
                ratingCount = 210,
                categoryId = 1,
                subTags = "Flutter,Mobile Development,App Development,iOS,Android"
            ),
            Course(
                id = 234,
                title = "Introduction to Cloud Computing with AWS",
                description = "Get introduced to cloud services with AWS, covering essential tools, security, and scalability in cloud environments.",
                thumbnailUrl = "https://images.squarespace-cdn.com/content/v1/60cfd646701da4034512a1c5/1654217981309-RTSZMBJWA9YJ5V32UN8R/AWS-Cloud.png",
                averageRating = 4.1f,
                ratingCount = 190,
                categoryId = 1,
                subTags = "AWS,Cloud Computing,Cloud Security,Scalability"
            ),
            Course(
                id = 235,
                title = "Learn Git and GitHub for Developers",
                description = "Learn how to use Git and GitHub to manage your code, collaborate with teams, and maintain version control.",
                thumbnailUrl = "https://media.licdn.com/dms/image/v2/D4D12AQFC7bQ9hFIxkQ/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1723981490996?e=2147483647&v=beta&t=CEg8w-_yBc9jD1aiKseh01aBc_wD44CMM8WizF9ZIAs",
                averageRating = 4.9f,
                ratingCount = 230,
                categoryId = 1,
                subTags = "Git,GitHub,Version Control,Collaboration,Development"
            ),
            Course(
                id = 236,
                title = "Introduction to Artificial Intelligence with Python",
                description = "Explore the fundamentals of AI, including machine learning, neural networks, and deep learning using Python.",
                thumbnailUrl = "https://d1jnx9ba8s6j9r.cloudfront.net/blog/wp-content/uploads/2019/06/Artificial-Intelligence-With-Python.jpg",
                averageRating = 3.8f,
                ratingCount = 240,
                categoryId = 1,
                subTags = "AI,Machine Learning,Deep Learning,Python,Artificial Intelligence"
            )
        )
        database.courseDao().insertAll(courses)
    }
}