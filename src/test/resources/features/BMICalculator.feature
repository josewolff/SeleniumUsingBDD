@bmiCalculator
Feature: BMICalculator
  As u user using the BMI calculator
  I want to be able to know my body mass index using my weight and height
  So I can be more healthly.

  Scenario Outline: Calculating BMI
    Given is using the running the test in <runOn> using the browser <browser>
    When the user navigates to "https://germavinsmoke.github.io/bmi-calculator/"
    And writes the weight <weight>
    And writes the height <height>
    And click the calculate BMI button
    Then the BMI result should be <expectedResult>
    Examples:
      | runOn     | browser      |  weight | height  |  expectedResult  |
      | "safari"  | "none"       | 5       | 6       |  1388.89         |
      | "chrome"  | "none"       | 5       | 6       |  1388.89         |
      | "firefox" | "none"       | 5       | 6       |  1388.89         |
      | "grid"    | "firefox59"  | 5       | 6       |  1368.89         |
      | "grid"    | "firefox70"  | 5       | 6       |  1388.89         |
      | "grid"    | "chrome66"   | 5       | 6       |  1388.999        |
      | "grid"    | "chrome78"   | 5       | 6       |  1388.89         |