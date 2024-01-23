package sevenedge.pdfreader.filereader.composables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import sevenedge.pdfreader.filereader.composables.ui.theme.ComposablesTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposablesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        item {
                            // Profile picture and basic info
                            TopSection()
                        }

                        item {
                            // About Section
                            AboutSection()
                        }

                        item {
                            // Experience Section
                            ExperienceSection()
                        }

                        item {
                            // Education Section
                            EducationSection()
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),

        ) {


        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth(0.5f),
        ) {
            // Profile picture
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)

                    .shadow(elevation = 4.dp)
                    .clickable(onClick = { /* Open image picker/cropping dialog */ }),
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
            )
            // Name
            Text(
                text = "Tariq Hussain",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            )

            // Headline
            Text(
                text = "Software Engineer",
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.End
        ) {


            Text(text = "Following: ___")

            Text(text = "Followers: ___")

            Spacer(modifier = Modifier.size(12.dp))
            Button(

                onClick = { /* Initiate desired action (Connect, Message, Follow) */ },
            ) {
                Text("Follow",  modifier = Modifier.padding(start = 12.dp, end = 12.dp))
            }
        }
        // Connections and followers icons

        // Call to action button
    }
}

@Composable
fun AboutSection() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "A passionate and results-oriented software engineer with X years of experience in ...",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(16.dp),
            /* .expandableText(
                 trimLines = 4,
                 moreText = "See More",
                 lessText = "Close",
                 onExpand = { */
            /* Handle expand/collapse events */
            /* }
                            )*/
        )
    }
}

@Composable
fun ExperienceSection() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = "Work Experience",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
        )

        // Individual experience cards
        listOf(
            ExperienceCard(
                logo = R.drawable.ic_launcher_background,
                jobTitle = "Software Engineer",
                dates = "Jan ____ - Present",
                description = "Led the development of ...",
                onDescriptionClick = { /* Open detail dialog */ }
            ),
            ExperienceCard(
                logo = R.drawable.ic_launcher_foreground,
                jobTitle = "Mobile Developer",
                dates = "Jun ___ - Dec ___",
                description = "Designed and built native Android apps ...",
                onDescriptionClick = { /* Open detail dialog */ }
            ),
        ).forEach {
            it
        }

        // See All button
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { /* Show all experiences list/grid */ },
        ) {
            Text("See All")
        }
    }
}

@Composable
fun EducationSection() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = "Education",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
        )

        listOf(
            EducationCard(
                institution = "Comsats University Islamabad",
                degree = "Bachelor of Science in Software Engineering",
                dates = "2017 - 2021",
                description = "Studied...",
                onDescriptionClick = { /* Open detail dialog */ }
            ),
            EducationCard(
                institution = "Collage",
                degree = "Pre Engineering",
                dates = "___",
                description = "______...",
                onDescriptionClick = { /* Open detail dialog */ }
            ),
        ).forEach {
            it
        }

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { /* Show all education list/grid */ },
        ) {
            Text("See All")
        }
    }
}

@Composable
fun ExperienceCard(
    logo: Int,
    jobTitle: String,
    dates: String,
    description: String,
    onDescriptionClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {
            // Company logo
            Image(
                painter = painterResource(id = logo),
                contentDescription = "Company logo",
                Modifier.size(52.dp)
            )

            // Job title and dates
            Column(
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically),

                ) {
                Text(
                    text = jobTitle,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                )
                Text(
                    text = dates,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                )

            }


        }
    }
}

@Composable
fun EducationCard(
    institution: String,
    degree: String,
    dates: String,
    description: String,
    onDescriptionClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {


            // Degree and dates
            Column(
                modifier = Modifier
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .weight(1f),
            ) {
                // Institution name
                Text(
                    text = institution,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                )
                Text(
                    text = degree,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                )
                Text(
                    text = dates,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposablesTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            item {
                TopSection()
            }

            item {
                AboutSection()
            }

            item {
                ExperienceSection()
            }

            item {
                EducationSection()
            }
        }


    }
}