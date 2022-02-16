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

    And home page opened

    When we are selecting airports

    And pressing GoGoGo button

    Then selected airports appear on Flight Details Page

    When we are filing in flight details form