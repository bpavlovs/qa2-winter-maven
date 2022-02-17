Feature: Ticket Booking System

  Scenario: API Reservation Check
    Given airports "RIX" and "SVO"

    And personal info is
      | first_name  | Bogdans    |
      | last_name   | Pavlovs    |
      | discount    | none       |
      | adult_count | 2          |
      | kid_count   | 2          |
      | bag_count   | 1          |
      | flight_date | 14-05-2018 |

    And home page open

    When selecting airports

    And pressing GoGoGo button

    Then selected airports appear on Flight Details Page

    When filing in flight details form

    And pressing Get Price button

    And pressing Book! button

    Given seat id is 4

    When pressing seat number button

    Then selected seat appears on the Flight Details Page

    When pressing final Book! button

    Given booking confirmation page open

    And confirmation message is "Thank You for flying with us!"

    Then flight confirmation message appears


