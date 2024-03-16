const person = {
    name : 'Adham',
    age : '23',
    address : {
        street : "Xaqiyqat",
        city : "Samarkand",
        country : "Uzbekistan"
    }, 
    profiles : ["twitter", "linkedin", 'instagram'],
    printProfiles : function() {
        this.profiles.map(
            profile => console.log(profile)
        )
        console.log(this.profiles[2]);
    }
}



export default function LearningJavaScript(){
    return (
        <>
        <div>{person.name}</div>
        <div>{person.address.city}</div>
        <div>{person.printProfiles()}</div>
        </>
    );
}