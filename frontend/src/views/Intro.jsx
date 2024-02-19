import { Boton } from '@components/Boton';
import { Stepper } from '@components/Stepper'
import imagen from '@/assets/imagenIntro.jpg'
import logoV from  '@/assets/V.jpg';
const Intro = () => {
  return (
    <main className='flex flex-wrap justify-center h-screen '>
 
<img 
src={imagen} 
alt="Frutas y verduras organicas, verduMarket" 
className='object-cover object-center w-full h-1/2 md:h-1/2 lg:h-1/2 max-w-1/3 md:max-w-2/3 lg:max-w-full rounded-xl '
/>  
<section className='flex flex-col justify-start '>
<img src={logoV} alt="logo V, verduMarket" className='items-start w-10 h-10'/>
</section>
<Stepper/>
<div className='flex gap-x-4'>
              <Boton texto="Comprar" to="/homecomprador" />
              <Boton texto="Vender " to="/homevendedor" />
</div>

    </main>
)
}

export default Intro