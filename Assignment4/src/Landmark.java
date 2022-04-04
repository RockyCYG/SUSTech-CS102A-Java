public enum Landmark {
    TeachingBuilding(new Library[]{Library.Yidan, Library.Lynn, Library.LearningNexus}),
    ResearchBuilding(new Library[]{Library.Lynn, Library.Yidan, Library.LearningNexus}),
    TaizhouFloor(new Library[]{Library.Lynn, Library.Yidan, Library.LearningNexus}),
    AdministrativeBuilding(new Library[]{Library.Lynn, Library.Yidan, Library.LearningNexus}),
    SUSTechCenter(new Library[]{Library.Yidan, Library.Lynn, Library.LearningNexus}),
    Dormitory(new Library[]{Library.LearningNexus, Library.Yidan, Library.Lynn}),
    Playground(new Library[]{Library.Yidan, Library.LearningNexus, Library.Lynn});


    private final Library[] priority;
    Landmark(Library[] priority) {
        this.priority = priority;
    }
}