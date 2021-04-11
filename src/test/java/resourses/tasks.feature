Feature: Проведение UI-тестирования Яндекс Маркета

  Scenario: Просмотр моделей ноутбоков по заданным фильтрам
    Given Go To Page Computer Technology
    When Go To Page Notebook
    Then Apply Filter Price "price"
    And Apply Filter Model "model1", "model2"
    And Apply Filter Color "color1", "color2"
    And Check Difference Price "low", "high"
    And Check Equal Of Two Notebooks

