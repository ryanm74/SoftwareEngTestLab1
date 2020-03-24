package ie.gmit.single;
//Design principal lab
//Ryan Murray
//G00340535
//24/03/20
//User Persistence Service

public class UserPersistenceService {
    private Store store = new Store();

    public void saveUser(User user)
    {
        store.store(user);
    }
}
