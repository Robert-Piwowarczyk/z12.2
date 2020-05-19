import java.util.Objects;

 class State {
    private String code;
    private String nameState;
    private int population;

     public State(String code, String nameState, int population) {
         this.code = code;
         this.nameState = nameState;
         this.population = population;
     }

     public String getCode() {
         return code;
     }

     public void setCode(String code) {
         this.code = code;
     }

     public String getNameState() {
         return nameState;
     }

     public void setNameState(String nameState) {
         this.nameState = nameState;
     }

     public int getPopulation() {
         return population;
     }

     public void setPopulation(int population) {
         this.population = population;
     }
     @Override
     public String toString(){
         return code + ";" + nameState + ";" + population;
     }
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         State state = (State) o;
         return Integer.compare(state.population, population) == 0 &&
                 Objects.equals(nameState, state.nameState);
     }
     @Override
     public int hashCode(){
         return Objects.hash(code,nameState,population);
     }
 }
