ReviewDefinitionsPage selectReviewTypeAndAddReviewDefinition(String reviewType, String reviewCat, String reviewName){
        cleanupReview(reviewName);
        log.info("Attempting to add review definition '$reviewName'")
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(addReviewBtn))
        log.info("Click on ${addReviewBtn.getText()} button...")
        clickElement addReviewBtn
        if (reviewType == null){
            log.info("Select 'User Access Review' by default...")
            selectComboItem reviewTypeDropdown, 'User Access Review'
        }
        else{
            log.info("Select '${reviewType}' in the menu...")
            selectComboItem reviewTypeDropdown, reviewType
        }

        By reviewCatPath = By.xpath("//a[contains(text(), '${reviewCat}')]")
        WebElement PickReviewCat = driver.findElement(reviewCatPath)
        log.info("Select '${reviewCat}' in the menu...")
        clickElement PickReviewCat
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'idenButtonContainer')]"))))
        log.info("Type ${reviewName} in Name field...")
        typeIntoElement reviewNameField, reviewName

        return this
    }
