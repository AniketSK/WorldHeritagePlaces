package com.aniketkadam.heritageplaces

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import java.lang.Thread.sleep

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun first_page_heritage_place_is_loaded_when_activity_launches() {
        sleep(2000) // Normally I'd use an Espresso Idling Resource, demonstrated here https://github.com/AniketSK/ArchitectureExperiments/blob/bf6ddf2becac1a49027c35b135c934fe0e30922c/app/src/androidTest/java/com/aniketkadam/temperatureapp/MainActivityTest.kt#L44
        onView(withId(R.id.heritageListRecyclerview)).perform(
            RecyclerViewActions.actionOnItem<HeritageViewHolder>(
                hasDescendant(withText("Aachen Cathedral ")), scrollTo()
            )
        )
    }

    @Test
    fun an_item_at_the_21st_position_is_displayed_which_would_need_to_be_paged_in() {
        sleep(2000) // Normally I'd use an Espresso Idling Resource, demonstrated here https://github.com/AniketSK/ArchitectureExperiments/blob/bf6ddf2becac1a49027c35b135c934fe0e30922c/app/src/androidTest/java/com/aniketkadam/temperatureapp/MainActivityTest.kt#L44
        onView(withId(R.id.heritageListRecyclerview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<HeritageViewHolder>(21, scrollTo())
        )
    }

    @Test
    fun clicking_on_an_item_opens_its_maps_location() {
        sleep(2000) // Normally I'd use an Espresso Idling Resource, demonstrated here https://github.com/AniketSK/ArchitectureExperiments/blob/bf6ddf2becac1a49027c35b135c934fe0e30922c/app/src/androidTest/java/com/aniketkadam/temperatureapp/MainActivityTest.kt#L44
        onView(withId(R.id.heritageListRecyclerview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<HeritageViewHolder>(1, click())
        )

        onView(withContentDescription("Google Map")).check(matches(isDisplayed()))
    }
}