const person = {
    name: 'Adkham', 
    address: {
        line1: '123 Lumumby',
        city: 'Lodz',
        country: 'Poland'
    }, 
    profiles: ['Twitter', 'Linkedin', 'Instagram'],
    printProfiles: () => {
        person.profiles.map(
            profile => console.log(profile)
        )
    }
}

export default function LearningJavaScript(){
    return(
        <div className="LearningJavaScript">
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.profiles[1]}</div>
            <div>{person.printProfiles()}</div>
        </div>
    );
}