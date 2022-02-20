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

    And seat id is 16

    When selecting airports

    And pressing GoGoGo button

    Then selected airports appear on Flight Details Page

    When filing in flight details form

    And pressing Get Price button

    And pressing Book! button

    When pressing seat number button

    Then selected seat appears on the Flight Details Page

    When pressing final Book! button

    Then flight confirmation message appears


